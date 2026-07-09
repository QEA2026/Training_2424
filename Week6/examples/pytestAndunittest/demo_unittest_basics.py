# Python unittest - The Built-in Testing Framework

#unittest is Python's built-in testing framework (part of standard library)
#follows xUnit Pattern - familiar to Java Developers
# Requires class inheritance from unittest.TestCase
#Uses specific assertion methods: assertEqual, assertTrue, assertRaises
# Good for: legacy code, Java developers transitioning, no extra dependencies

# Run with this:
    #python -m unittest demo_unittest_basics.py -v
    #python -m unittest demo_unittest_basics.TestCalculator.test_add -v
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