import re


class Solution:
    def isNumber(self, s: str) -> bool:
        int_p = re.compile("(\+|-)?[0-9]+")
        float_p = re.compile(
            f"(({int_p.pattern})|({int_p.pattern}\.[0-9]*)|((\+|-)?\.[0-9]+))"
        )
        tail = f"([eE](\+|-)?[0-9]+)?"
        sci_p = re.compile(float_p.pattern + tail)
        if sci_p.fullmatch(s):
            return True
        return False
