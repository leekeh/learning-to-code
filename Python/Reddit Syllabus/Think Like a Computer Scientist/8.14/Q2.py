def print_triangular_numbers(n):
    for i in range (1, n+1):
        nr = int((i*(i+1))/2)
        print ("{} \t{}".format(i, nr))

print_triangular_numbers(5)
