import pytest
from loan_eligibility import assess_loan

def test_happy_path_eligible():
    """All condition False -> ELIGIBLE. One test, many uncovered branches"""
    assert assess_loan(age=30,income=30000,credit_score=700,employed=True) == "ELIGIBLE"

# def test_happy_path_eligible():
#     assert assess_loan(age=30,income=30000) == "ELIGIBLE"