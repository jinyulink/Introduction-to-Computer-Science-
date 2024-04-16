def print_hex(oct_num):
    total = ""
    g, h = divmod(oct_num, 16)
    oct_num = g
    if h>=10:
        h = str(h)
        h=chr(h-10+ord('a'))
    total += h
    while g != 0:
        g, h = divmod(oct_num, 16)
        oct_num = g
        h = str(h)
        if h>=10:
            h = str(h)
            h=chr(h-10+ord('a'))
        total += h
    total = total[::-1]
    return total
