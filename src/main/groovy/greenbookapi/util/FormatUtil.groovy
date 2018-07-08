package greenbookapi.util

class FormatUtil {

    static String stripSpecialCharacters (String input) {
        input = input.replace('\\', '')
        input = input.replace('\0', '')
        input = input.replace('\'', '')
        input = input.replace('\"', '')
        input = input.replace('\b', '')
        input = input.replace('\n', '')
        input = input.replace('\r', '')
        input = input.replace('\t', '')
        input = input.replace('%', '')
        input = input.replace('_', '')
        input
    }
}
