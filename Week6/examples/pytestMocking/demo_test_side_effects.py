#side_effect - Dynamic Mock Behavior

# side_effect allows dynamic responses based on calls
# can return different values on successive calls
#can raise exceptions
#can be a callable for complex logic
# Essential for testing retry logic, error handling, etc.

import pytest
from unittest.mock import Mock, MagicMock

#side_effect for raising exceptions
def test_side_effect_raises_exception():
    """
    Use side_effect to make mock raise an exception.
    """
    mock_func = Mock()
    mock_func.side_effect = ValueError("Invalid Input")

    with pytest.raises(ValueError) as exc_info:
        mock_func()

    assert "Invalid Input" in str(exc_info.value)

def test_side_effect_different_exceptions():
    """
    Different exceptions for different calls
    """
    mock = Mock()
    mock.side_effect = [
        ConnectionError("Network Failed"),
        TimeoutError("Request timed out"),
        {"result": "success"} #finally succeeds
    ]

    with pytest.raises(ConnectionError):
        mock()

    with pytest.raises(TimeoutError):
        mock()

    result = mock()
    assert result == {"result":"success"}
    