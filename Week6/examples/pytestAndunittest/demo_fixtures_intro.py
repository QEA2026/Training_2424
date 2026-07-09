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

# Fixtures with Setup and TearDown(yield)
@pytest.fixture
def temp_file(tmp_path):
    """Create a temp file, provide it, then clean it up
    'tmp_path is a built-in pytest fixture"""

    #SETUP
    file_path = tmp_path / "test_data.txt"
    file_path.write_text("test content")
    print(f"\n[SETUP] Created temo file: {file_path}")

    #PROVIDE TO TEST
    yield file_path

    #TEARDOWN (runs even if test fails!)
    print(f"[TEARDOWN] Cleaning up : {file_path}")
    if file_path.exists():
        file_path.unlink()

def test_temp_file_exists(temp_file):
    """Test receives the temp file path."""
    assert temp_file.exists()
    assert temp_file.read_text() == "test content"

def test_temp_file_can_be_modified(temp_file):
    """Each test gets its own temp file."""
    temp_file.write_text("modified content")
    assert temp_file.read_text() == "modified content"

#Fixture Scopes
@pytest.fixture(scope="function") #default - new instance per test
def function_scoped_calc():
    print("\n[FUNCTION FIXTURE] Creating calculator")
    calc = Calculator()
    yield calc
    
    print("[FUNCTION FIXTURE] cleaning up")

@pytest.fixture(scope = "class") #one instance for entire module
def class_scoped_calc():
    print("\n[CLASS FIXTURE] Creating calculator (once per class)")
    calc = Calculator()

    yield calc

    print("[CLASS FIXTURE] Cleaning up")

@pytest.fixture(scope = "module") #one instance for entire module
def module_scoped_calc():
    print("\n[MODULE FIXTURE] Creating calculator (once per module)")
    calc = Calculator()

    yield calc

    print("[MODULE FIXTURE] Cleaning up")

class TestModuleScoped:
    """Tests sharing module-scoped fixture"""
    def test_module_1(self, module_scoped_calc):
        """Uses shared module calculator"""
        assert module_scoped_calc.add(1,1)==2
    
    def test_module_2(self, module_scoped_calc):
        """Same calculator instance as test_module_1"""
        assert module_scoped_calc.add(2,2)==4






