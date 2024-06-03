import sys
from string import ascii_lowercase
 
s = sys.stdin.readline()
z_cnt = int(s.count("0")/2)
o_cnt = int(s.count("1")/2)


print("0"*z_cnt + "1"*o_cnt)