#calculator test using pytest

import pytest
import math

def test_sum():
    num1 = 10
    num2 = 15
    sum = num1+num2
    assert sum == 25

def test_difference():
    num1 = 15
    num2 = 10
    difference = num1-num2
    assert difference == 5

def test_multiply():
    num1 = 10
    num2 = 15
    prod = num1*num2
    assert prod == 150

def test_divide():
    num1 = 100
    num2 = 5
    quotient = num1/num2
    assert quotient == 20


