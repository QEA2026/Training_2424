print("hello world")

#numeric datatypes are integer and float
my_integer = 1 # no decimal
my_float = 1.1 #can handle decimals

print(type(my_integer))
print(type(my_float))

# String is the data type that handles words/text
my_string = "this handles words/text"

#booleans can wither be True or False
my_true_boolean = True
my_false_boolean = False

#None can be assigned as a type: useful for avoiding errors
my_none = None

my_string_literal = "the string literal is the content of the string"

name = "Will"
greeting = "Hello" + name

# if you place an f before the first quote you can make a formatted string
formatted_string = f"Hello {name}"

print(greeting)
print(formatted_string)

import re

text = "Order ID: 12345"

#print(f"Found ID:{re.search(r'\d+',text).group()}")

match = re.search(r"\d+", text)
if match:
    print(f"Found ID:{match.group()}")

#you can also use the .format() method to format your string
formatted_by_method_string = "Hello {}".format("Will")

print(formatted_by_method_string)

my_string = "Hello Will"
just_hello = my_string[0:5]
print(just_hello)
