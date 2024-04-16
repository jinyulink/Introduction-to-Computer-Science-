"""
Practice 5
Name: 
Student Number: 
Course 
"""
def split_info( input_list ) :
  # Your inputList should be a list of strings, containing the student's name and score, such as:
  # [ 'John','10','4','5','12', 'Mary','10','4','5','12', 'Tom','10','4','5','12' ]
  # this Function Should Return a list of lists, containing the student's name and score, such as:
  # [ [ 'John','10','4','5','12' ] , [ 'Mary','10','4','5','12' ] , [ 'Tom','10','4','5','12' ] ]

  return_list = []
  # Write your code here
  return return_list # should be: [ [ 'John','10','4','5','12' ] , [ 'Mary','10','4','5','12' ] , [ 'Tom','10','4','5','12' ] ]

def grading_system( student_list ) :
  # studentList should be a list of strings, containing the student's name and score, such as:
  # [ 'John','10','4','5','12']
  # this Function Should Return with a string, representing weather the student can enter NCU CSIE, such as:
  # "Hello "+ name + ", welcome to NCU CSIE!" 
  # or
  # "Sorry, " + name + " can't enter NCU CSIE." 

  return_str = ''
  # Write your code here
  return return_str # should be: "Hello "+ name + ", welcome to NCU CSIE!"  or "Sorry, " + name + " can't enter NCU CSIE." 

# Main Function
# Write Your Code Here
s_file_name = "score.txt"