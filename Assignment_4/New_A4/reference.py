def exist_num( arr,num ):
    arr: arr
    flag: bool
    # 確認數字（Number_i）是否存在於文件中，如果存在請回傳True，反之不存在回傳False
    # Input type: int
    # Return type: bool
    return flag

def count_factor( num ):
    count: int
    # 文件裡數字（Number_i）後面會附帶所有因數，請利用此function計算因數個數。
    # Input type: int
    # Return type: int
    return count

def count_prime( num ):
    count: int
    # 文件裡數字（Number_i）後面會附帶所有因數，請利用此function計算質數個數。
    # Input type: int
    # Return type: int
    return count

num: int
factor_num: int
prime_num: int

msg1 = "Input the number to check exist or exit : "
msg2 = "Number_%d is not existed, please input a new number or input \"exit\" to leave program.",num
msg3 = "Number_%d exists in the document and the number of factor is %d and the number of prime is %d.",num,factor_num,prime_num
msg4 = "Please input the next number or input \"exit\" to leave."
file_name= "Input.txt"
file_pwd= "Input.txt"