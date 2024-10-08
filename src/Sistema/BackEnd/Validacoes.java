package Sistema.BackEnd;

public class Validacoes {

    public boolean validarCpf(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais, o que torna o CPF inválido
        boolean digitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // Calcula e compara o dígito verificador
        int[] numerosCPF = new int[11];
        for (int i = 0; i < 11; i++) {
            numerosCPF[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numerosCPF[i] * (10 - i);
        }

        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += numerosCPF[i] * (11 - i);
        }

        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        return (numerosCPF[9] == digito1 && numerosCPF[10] == digito2);
    }

    public String formatarCpf(String cpf) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = cpf.replaceAll("[^\\d]", "");

        // Verifica se o CPF possui 11 dígitos
        if (apenasDigitos.length() != 11) {
            return null; // Retorna null se o CPF não tiver 11 dígitos
        }

        // Formata o CPF no padrão desejado
        StringBuilder cpfFormatado = new StringBuilder();
        cpfFormatado.append(apenasDigitos.substring(0, 3)); // Primeiros 3 dígitos
        cpfFormatado.append(".");
        cpfFormatado.append(apenasDigitos.substring(3, 6)); // Próximos 3 dígitos
        cpfFormatado.append(".");
        cpfFormatado.append(apenasDigitos.substring(6, 9)); // Próximos 3 dígitos
        cpfFormatado.append("-");
        cpfFormatado.append(apenasDigitos.substring(9)); // Últimos 2 dígitos

        return cpfFormatado.toString();
    }

}
