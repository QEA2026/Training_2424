#PyTest Fixtures - Setup, Teardown, and Dependency Injection
# Fixtures are pytests's anser to setup/teardown - but WAY more powerful
#Fixtures use dependency injection - just add parameter to test function
#use 'yield' for setup-teardown pattern (cleanup runs even if test fails)
#Scopes control fixture lifetime: function, class, module, session
#conftest.py shares fixtures across test files

#RUN THIS WITH:
    #pytest demo_fixtures_intro.py -v
    #pytest demo_fixtures_intro.py -v -s # -s shows print statements

import pytest
from calculator import Calculator, StringCalculator

#Basic Fixtures

@pytest.fixture
def calculator():
    """provide a calculator instance for tests
    Any test that has 'calculator' as a parameter gets this fixture injected"""
    return Calculator()
@pytest.fixture
def string_calculator():
    """Provide a StringCalculator instance."""
    return StringCalculator()

def test_add_with_fixture(calculator):
    """Calculator is automaticlly injected!"""
    result = calculator.add(2,3)
    assert result == 5

def test_subtract_with_fixture(calculator):
    """Each test gets a fresh calculator instance"""
    result = calculator.subtract(10,3)
    assert result == 7

def test_string_add(string_calculator):
    result = string_calculator.add("1,2,3")
    assert result == 6

