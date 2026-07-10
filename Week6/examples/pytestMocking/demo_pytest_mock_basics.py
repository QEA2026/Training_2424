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

def test_mocker_mock_with_spec(mocker):
    """
    Use spec to ensure mock has same interface as real object.

    Catches typos in method names!
    """
    mock_repo = mocker.Mock(spec=UserRepository)

    #This works -find_by_id exists on UserRepository
    mock_repo.find_by_id.return_value = User(1,"John","john@test.com")

    #This would reaise AttributeError if uncommented:
    # mock_repo.find_by_idd.return_value = None #Typo!

    user = mock_repo.find_by_id(1)
    assert user.name == "John"

