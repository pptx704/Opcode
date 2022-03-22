changes = {'.': 0, ',': 1, '+': 2, '-': 3, '>':4, '<': 5, '[': 6, ']': 7}
def convert(code):
    current = 0
    x = ""
    for i in code:
        dest = changes.get(i)
        if dest is None:
            continue
        diff = (dest - current) % 8
        x += "+" * diff + "!"
        current = dest
        print(current)
    return x