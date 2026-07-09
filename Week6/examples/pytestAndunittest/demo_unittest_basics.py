# Python unittest - The Built-in Testing Framework

#unittest is Python's built-in testing framework (part of standard library)
#follows xUnit Pattern - familiar to Java Developers
# Requires class inheritance from unittest.TestCase
#Uses specific assertion methods: assertEqual, assertTrue, assertRaises
# Good for: legacy code, Java developers transitioning, no extra dependencies

# Run with this:
    #python -m unittest demo_unittest_basics.py -v
    #ython -m unittest demo_unittest_basics.TestCalculatorBasic.test_add_returns_sum  -v
#Compare WITH PYTEST:
    #pytest demo_unittest_basics.py -v #Pytest can run unittest tests!

import unittest
from calculator import Calculator

class TestCalculatorBasic(unittest.TestCase):
    """
    Basic calculator tests using unittest.

    NOTE:
    - Class inherits from unittest.TestCase
    - Methods start with 'test_'
    - Uses self.assertEqual, self.assertTrue, etc.
    """

    def setUp(self):
        """
        called before EACH test method
        Similar to @BeforeEach in JUnit
        """
        self.calc = Calculator()

    def tearDown(self):
        """
        Called after EACH test method.
        Similar to @AfterEach in JUnit.
        """
        self.calc = None
    # Basic Assertion Methods
    def test_add_returns_sum(self):
        """Test addition with AssertEqual."""
        result = self.calc.add(2,3)
        self.assertEqual(5,result) #Expected first, then actual

    def test_subtract_returns_difference(self):
        """Test substraction"""
        self.assertEqual(7,self.calc.subtract(10,3))

    def test_multiply_returns_product(self):
        """Test multiply with message on failure."""
        result = self.calc.multiply(4,5)
        self.assertEqual(20,result,"4*5 should equal 20")

    #Boolean Assertion
    def test_is_even_true(self):
        """User assertTrue for boolean True."""
        self.assertTrue(self.calc.is_even(2))
        self.assertTrue(self.calc.is_even(0))
        self.assertTrue(self.calc.is_even(-4))

    def test_is_even_false(self):
        """Use assertFalse for boolean False."""
        self.assertFalse(self.calc.is_even(1))
        self.assertFalse(self.calc.is_even(-1))

    def test_is_positive(self):
        """Combined boolean assertions."""
        self.assertTrue(self.calc.is_positive(1))
        self.assertFalse(self.calc.is_positive(0))
        self.assertFalse(self.calc.is_positive(-1))
        self.assertTrue(self.calc.is_positive(100))

    #Comparison assertions
    def test_greater_than(self):
        """Use assertGreater and assertLess."""
        self.assertGreater(self.calc.add(5,5),8)
        self.assertLess(self.calc.subtract(10,3),10)
        self.assertGreaterEqual(self.calc.multiply(2,3),6)
        self.assertLessEqual(self.calc.divide(10,2),5)

    #None and Type assertions
    def test_assert_none(self):
        """Use assertIsNone and assertIsNotNone"""
        result = self.calc.add(1,2)
        self.assertIsNotNone(result)

    def test_assert_type(self):
        """Use assertIsInstance for type checking."""
        result = self.calc.divide(10,3)
        self.assertIsInstance(result, float)

    #Exception Testing
    def test_divide_by_zero_raises_exception(self):
        """Use assertRaises to test exceptions
        Can be used as context manager(recommended) or callable"""
        #Context manager style (recommended)
        with self.assertRaises(ZeroDivisionError):
            self.calc.divide(10,0)
    
    def test_divide_by_zero_exception_message(self):
        with self.assertRaises(ZeroDivisionError) as context:
            self.calc.divide(10,0)

        self.assertIn("zero",str(context.exception).lower())

    def test_negative_exponent_raises_value_error(self):
        """Test ValueError for negative exponent."""
        with self.assertRaises(ValueError) as context:
            self.calc.power(2,-1)
        self.assertIn("negative",str(context.exception).lower())