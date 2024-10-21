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

    public boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Calcula e compara os dígitos verificadores
        int[] numerosCNPJ = new int[14];
        for (int i = 0; i < 14; i++) {
            numerosCNPJ[i] = Character.getNumericValue(cnpj.charAt(i));
        }

        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            soma += numerosCNPJ[i] * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        int digito1 = soma % 11;
        if (digito1 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - digito1;
        }

        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            soma += numerosCNPJ[i] * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        int digito2 = soma % 11;
        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - digito2;
        }

        return (numerosCNPJ[12] == digito1 && numerosCNPJ[13] == digito2);
    }

    public String formatarCNPJ(String cnpj) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = cnpj.replaceAll("[^\\d]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (apenasDigitos.length() != 14) {
            return null; // Retorna null se o CNPJ não tiver 14 dígitos
        }

        // Formata o CNPJ no padrão desejado
        StringBuilder cnpjFormatado = new StringBuilder();
        cnpjFormatado.append(apenasDigitos.substring(0, 2)); // Primeiros 2 dígitos
        cnpjFormatado.append(".");
        cnpjFormatado.append(apenasDigitos.substring(2, 5)); // Próximos 3 dígitos
        cnpjFormatado.append(".");
        cnpjFormatado.append(apenasDigitos.substring(5, 8)); // Próximos 3 dígitos
        cnpjFormatado.append("/");
        cnpjFormatado.append(apenasDigitos.substring(8, 12)); // Próximos 4 dígitos
        cnpjFormatado.append("-");
        cnpjFormatado.append(apenasDigitos.substring(12)); // Últimos 2 dígitos

        return cnpjFormatado.toString();
    }

    public String formatarTelefone(String telefone) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = telefone.replaceAll("[^\\d]", "");

        // Verifica se o telefone tem pelo menos 8 ou 9 dígitos
        if (apenasDigitos.length() < 8 || apenasDigitos.length() > 9) {
            return null; // retorna null se o número não for válido
        }

        // Formata o telefone no padrão desejado
        StringBuilder formatoTelefone = new StringBuilder();
        if (apenasDigitos.length() == 8) { // Número fixo
            formatoTelefone.append(apenasDigitos.substring(0, 4)); // Primeira parte do número
            formatoTelefone.append("-");
            formatoTelefone.append(apenasDigitos.substring(4)); // Segunda parte do número
        } else { // Número celular
            formatoTelefone.append(apenasDigitos.substring(0, 5)); // Primeira parte do número
            formatoTelefone.append("-");
            formatoTelefone.append(apenasDigitos.substring(5)); // Segunda parte do número
        }

        return formatoTelefone.toString();
    }

    public boolean validarCEP(String cep) {
        // Remove caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        // Verifica se o CEP possui 8 dígitos
        return cep.length() == 8;
    }

    public String formatarCEP(String cep) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = cep.replaceAll("[^\\d]", "");

        // Verifica se o CEP possui 8 dígitos
        if (apenasDigitos.length() != 8) {
            return null; // Retorna null se o CEP não tiver 8 dígitos
        }

        // Formata o CEP no padrão desejado
        StringBuilder cepFormatado = new StringBuilder();
        cepFormatado.append(apenasDigitos.substring(0, 5)); // Primeiros 5 dígitos
        cepFormatado.append("-");
        cepFormatado.append(apenasDigitos.substring(5)); // Últimos 3 dígitos

        return cepFormatado.toString();
    }

}
