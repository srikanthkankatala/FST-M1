import pytest

# Addition test
@pytest.mark.activity
def test_addition():
    # Initialize two numbers
    num1 = 10
    num2 = 15

    # Add them
    result = num1 + num2

    # Assertion
    assert result == 25


# Subtraction test
@pytest.mark.activity
def test_subtraction():
    # Initialize two numbers
    num1 = 50
    num2 = 35

    # Subtract them
    result = num1 - num2

    # Assertion
    assert result == 15


# Multiplication test
@pytest.mark.activity
def test_multiplication():
    # Initialize two numbers
    num1 = 5
    num2 = 20

    # Multiply them
    result = num1 * num2

    # Assertion
    assert result == 100


# Division test
@pytest.mark.activity
def test_division():
    # Initialize two numbers
    num1 = 100
    num2 = 5

    # Divide them
    result = num1 / num2

    # Assertion
    assert result == 20
