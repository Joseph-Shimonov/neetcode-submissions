class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        output = []
        i = 0
        line, length = [], 0

        while i < len(words):
            # check if we can add the next word
            if maxWidth < length + len(line) + len(words[i]):
                extra_space = maxWidth - length
                spaces = extra_space // max(1, len(line)-1)
                remainder = extra_space % max(1, len(line)-1)

                for j in range(max(1, len(line)-1)):
                    line[j] += " " * spaces
                    if remainder:
                        line[j] += " "
                        remainder -= 1
                
                output.append("".join(line))
                line, length = [], 0

            line.append(words[i])
            length += len(words[i])
            i += 1
        
        last_line = " ".join(line)
        trailing_space = maxWidth - len(last_line)
        output.append(last_line + " " * trailing_space)
        return output 