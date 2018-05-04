import sys


def has_duplicates(line: str) -> bool:
    words = set()
    for word in line.split():
        if word and word in words:
            return True
        words.add(word)

    return False


if __name__ == '__main__':
    # https://open.kattis.com/problems/nodup
    print('yes' if not has_duplicates(sys.stdin.readline()) else 'no')
