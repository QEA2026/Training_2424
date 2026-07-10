#Mock is the basic mock class
# MagicMock extends Mock with magig method support (__str__,__len__,etc.)
# Use Mock for simple mocking, MagicMock when magic methods are needed
#spec= ensures mock has same interface as real object
#autospec creates mocks that validate argument signatures

import pytest
from unittest.mock import Mock, MagicMock, create_autospec

# MagicMock - mock with magic methods
def test_magic_mock_supports_magic_methods():
    """MagicMock pre-configures magic methods (__str__,__len__, etc.)"""
    magic = MagicMock()
    # These work out of the box with MagicMock
    str(magic)
    len(magic)
    iter(magic)
    bool(magic)
    magic[0] #__getitem__
    magic["key"] #__getitem___

    #with regular Mock, these would fail without configuration
    regular = Mock()
    #len(regular) #TypeError: object of type 'Mock' has no len()

def test_magic_mock_configure_magic_methods():
    """
    Configure magic method return values.
    """
    magic = MagicMock()

    #configure __len__ to return 5
    magic.__len__.return_value = 5
    assert len(magic) == 5

    #Configure __getitem__ for subscript access
    magic.__getitem__.return_value = "item"
    assert magic[0] =="item"
    assert magic["any_key"] == "item"

    