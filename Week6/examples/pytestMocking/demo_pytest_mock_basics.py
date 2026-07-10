# Pytest-Mock Basics
# pytest-mock provides the "mocker" fixture
# automatically cleans up patches after each test
# No context managers or decorators needed
# Same API as unittest.mock but more Pythonic
# Install with: pip install pytest-mock

import pytest
from services import UserService, User, UserRepository, EmailClient

#basic mock creation
def test_mocker_creates_mocks(mocker):
    """
    The mocker fixture creates mock objects.

    mocker.Mock() creates a basic mock.
    mocker.MagicMock() creates a mock with magic methods.
    """
    #Creates basic mock
    mock_func = mocker.Mock()
    mock_func.return_value = 42

    result = mock_func()

    assert result == 42
    mock_func.assert_called_once()
