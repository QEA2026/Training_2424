# Pytest-Mock Basics
# pytest-mock provides the "mocker" fixture
# automatically cleans up patches after each test
# No context managers or decorators needed
# Same API as unittest.mock but more Pythonic
# Install with: pip install pytest-mock

import pytest
import os
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

# mocker.patch() - patching made easy

def test_mocker_patch(mocker):
    """
    mocker.patch() replaces objects during test
    automatically cleaned up after test
    """
    #Patch os.path.exists to always return True
    mock_exists = mocker.patch('os.path.exists',return_value=True)

    assert os.path.exists('/any/path/at/all') is True
    assert os.path.exists('/fake/path') is True

    mock_exists.assert_called()

def test_mocker_patch_dict(mocker):
    """
    mocker.patch.dict() patches dictionary contents.

    great for environmental variables!
    """
    mocker.patch.dict(os.environ, {
        'API_KEY':'test-key-123',
        'DEBUG':'true'
    })

    assert os.environ['API_KEY'] == 'test-key-123'
    assert os.environ['DEBUG'] == 'true'

def test_mocker_patch_object(mocker):
    """
    mocker.patch.object() patches a specific method on an object.
    """
    user = User(1,"original","original@test.com")

    #Patch just the email property
    mocker.patch.object(user, 'email','patched@test.com')

    assert user.email == 'patched@test.com'
    assert user.name == "original" #Not patched



