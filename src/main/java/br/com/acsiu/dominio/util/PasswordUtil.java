package br.com.acsiu.dominio.util;

import java.util.Base64;

import br.com.acsiu.dominio.dto.ResultPasswordDTO;

public final class PasswordUtil {
	private static ResultPasswordDTO resultPassword;

	static int nScore = 0;
	static int nLength = 0;
	static int nAlphaUC = 0;
	static int nAlphaLC = 0;
	static int nNumber = 0;
	static int nSymbol = 0;
	static int nMidChar = 0;
	static int nRequirements = 0;
	static int nAlphasOnly = 0;
	static int nNumbersOnly = 0;
	static int nUnqChar = 0;
	static int nRepChar = 0;
	static int nRepInc = 0;
	static int nConsecAlphaUC = 0;
	static int nConsecAlphaLC = 0;
	static int nConsecNumber = 0;
	static int nConsecSymbol = 0;
	static int nConsecCharType = 0;
	static int nSeqAlpha = 0;
	static int nSeqNumber = 0;
	static int nSeqSymbol = 0;
	static int nSeqChar = 0;
	static int nReqChar = 0;
	static int nMultMidChar = 2;
	static int nMultConsecAlphaUC = 2;
	static int nMultConsecAlphaLC = 2;
	static int nMultConsecNumber = 2;
	static int nMultSeqAlpha = 3;
	static int nMultSeqNumber = 3;
	static int nMultSeqSymbol = 3;
	static int nMultLength = 4;
	static int nMultNumber = 4;
	static int nMultSymbol = 6;
	static int nTmpAlphaUC = 0;
	static int nTmpAlphaLC = 0;
	static int nTmpNumber = 0;
	static int nTmpSymbol = 0;
	static int nMinPwdLen = 8;
	static int nMinReqChars = 0;

	static String sAlphaUC = "0";
	static String sAlphaLC = "0";
	static String sNumber = "0";
	static String sSymbol = "0";
	static String sMidChar = "0";
	static String sRequirements = "0";
	static String sAlphasOnly = "0";
	static String sNumbersOnly = "0";
	static String sRepChar = "0";
	static String sConsecAlphaUC = "0";
	static String sConsecAlphaLC = "0";
	static String sConsecNumber = "0";
	static String sSeqAlpha = "0";
	static String sSeqNumber = "0";
	static String sSeqSymbol = "0";

	static String sAlphas = "abcdefghijklmnopqrstuvwxyz";
	static String sNumerics = "01234567890";
	static String sSymbols = ")!@#$%^&*()";
	static String sComplexity = "Muito curto";
	static String vScore = "";
	static String vComplexity = "";

	public static String strReverse(String str) {
		StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}
		return reversed.toString();
	}

	public static ResultPasswordDTO nivelSenha(String pwd) {
		nLength = pwd.length();
		if (pwd != null) {
			nScore = pwd.length() * nMultLength;
			nLength = pwd.length();
			var arrPwd = pwd.replaceAll("/\s+/g", "").split("/\s*/");
			var arrPwdLen = arrPwd.length;

			/*
			 * Loop through password to check for Symbol, Numeric, Lowercase and Uppercase
			 * pattern matches
			 */
			for (var a = 0; a < arrPwdLen; a++) {
				if (arrPwd[a].matches("/[A-Z]/g")) {
					if (nTmpAlphaUC > -1) {
						if (nTmpAlphaUC + 1 == a) {
							nConsecAlphaUC++;
							nConsecCharType++;
						}
						nTmpAlphaUC = a;
						nAlphaUC++;
					} else if (arrPwd[a].matches("/[a-z]/g")) {
						if (nTmpAlphaLC > -1) {
							if (nTmpAlphaLC + 1 == a) {
								nConsecAlphaLC++;
								nConsecCharType++;
							}
						}
						nTmpAlphaLC = a;
						nAlphaLC++;
					} else if (arrPwd[a].matches("/[0-9]/g")) {
						if (a > 0 && a < arrPwdLen - 1) {
							nMidChar++;
						}
						if (nTmpNumber > -1) {
							if (nTmpNumber + 1 == a) {
								nConsecNumber++;
								nConsecCharType++;
							}
						}
						nTmpNumber = a;
						nNumber++;
					} else if (arrPwd[a].matches("/[^a-zA-Z0-9_]/g")) {
						if (a > 0 && a < arrPwdLen - 1) {
							nMidChar++;
						}
						if (nTmpSymbol > -1) {
							if (nTmpSymbol + 1 == a) {
								nConsecSymbol++;
								nConsecCharType++;
							}
						}
						nTmpSymbol = a;
						nSymbol++;
					}
					/* Loop interno através da senha para verificar caracteres repetidos */
					var bCharExists = false;
					for (var b = 0; b < arrPwdLen; b++) {
						if (arrPwd[a] == arrPwd[b] && a != b) {
							/* existe caractere de repetição */
							bCharExists = true;
							/*
							* Calcula a dedução do incremento com base na proximidade de caracteres idênticos
							* A dedução aumenta cada vez que uma nova correspondência é descoberta. Valor da dedução
							* é baseado no comprimento total da senha dividido pela diferença de distância
							* entre a partida atualmente selecionada
							*/
							nRepInc += Math.abs(arrPwdLen / (b - a));
						}
					}
					if (bCharExists) {
						nRepChar++;
						nUnqChar = arrPwdLen - nRepChar;
						nRepInc = (int) (nUnqChar > 0 ? Math.ceil(nRepInc / nUnqChar) : Math.ceil(nRepInc));
					}
				}
				/* Verifica padrões de strings alfa sequenciais (avanço e reverso) */
				for (var s = 0; s < 23; s++) {
					var sFwd = sAlphas.substring(s, (s + 3));
					var sRev = strReverse(sFwd);
					if (pwd.toLowerCase().indexOf(sFwd) != -1 || pwd.toLowerCase().indexOf(sRev) != -1) {
						nSeqAlpha++;
						nSeqChar++;
					}
				}
				/* Verifica padrões de strings numéricas sequenciais (avanço e reverso) */
				for (var s = 0; s < 8; s++) {
					var sFwd = sNumerics.substring(s, (s + 3));
					var sRev = strReverse(sFwd);
					if (pwd.toLowerCase().indexOf(sFwd) != -1 || pwd.toLowerCase().indexOf(sRev) != -1) {
						nSeqNumber++;
						nSeqChar++;
					}
				}
				/* Verifica padrões de sequência de símbolos sequenciais (avanço e reverso) */
				for (var s = 0; s < 8; s++) {
					var sFwd = sSymbols.substring(s, (s + 3));
					var sRev = strReverse(sFwd);
					if (pwd.toLowerCase().indexOf(sFwd) != -1 || pwd.toLowerCase().indexOf(sRev) != -1) {
						nSeqSymbol++;
						nSeqChar++;
					}
				}
				/* Modifica o valor da pontuação geral com base no uso versus requisitos */
				if (nAlphaUC > 0 && nAlphaUC < nLength) {
					nScore = (nScore + (nLength - nAlphaUC) * 2);
					sAlphaUC = "+ " + String.valueOf((nLength - nAlphaUC) * 2);
				}
				if (nAlphaLC > 0 && nAlphaLC < nLength) {
					nScore = (nScore + (nLength - nAlphaLC) * 2);
					sAlphaLC = "+ " + String.valueOf((nLength - nAlphaLC) * 2);
				}
				if (nNumber > 0 && nNumber < nLength) {
					nScore = (nScore + nNumber * nMultNumber);
					sNumber = "+ " + String.valueOf(nNumber * nMultNumber);
				}
				if (nSymbol > 0) {
					nScore = (nScore + nSymbol * nMultSymbol);
					sSymbol = "+ " + String.valueOf(nSymbol * nMultSymbol);
				}
				if (nMidChar > 0) {
					nScore = (nScore + nMidChar * nMultMidChar);
					sMidChar = "+ " + String.valueOf(nMidChar * nMultMidChar);
				}

				/* Deduções de pontos por práticas inadequadas */
				if ((nAlphaLC > 0 || nAlphaUC > 0) && nSymbol == 0 && nNumber == 0) {
					// Somente letras
					nScore = (nScore - nLength);
					nAlphasOnly = nLength;
					sAlphasOnly = "- " + String.valueOf(nLength);
				}
				if (nAlphaLC == 0 && nAlphaUC == 0 && nSymbol == 0 && nNumber > 0) {
					// Apenas números
					nScore = (nScore - nLength);
					nNumbersOnly = nLength;
					sNumbersOnly = "- " + String.valueOf(nLength);
				}
				if (nRepChar > 0) {
					// O mesmo personagem existe mais de uma vez
					nScore = (nScore - nRepInc);
					sRepChar = "- " + String.valueOf(nRepInc);
				}
				if (nConsecAlphaUC > 0) {
					// Existem letras maiúsculas consecutivas
					nScore = (nScore - nConsecAlphaUC * nMultConsecAlphaUC);
					sConsecAlphaUC = "- " + String.valueOf(nConsecAlphaUC * nMultConsecAlphaUC);
				}
				if (nConsecAlphaLC > 0) {
					// Existem letras minúsculas consecutivas
					nScore = (nScore - nConsecAlphaLC * nMultConsecAlphaLC);
					sConsecAlphaLC = "- " + String.valueOf(nConsecAlphaLC * nMultConsecAlphaLC);
				}
				if (nConsecNumber > 0) {
					// Existem números consecutivos
					nScore = (nScore - nConsecNumber * nMultConsecNumber);
					sConsecNumber = "- " + String.valueOf(nConsecNumber * nMultConsecNumber);
				}
				if (nSeqAlpha > 0) {
					// Existem strings alfa sequenciais (3 caracteres ou mais)
					nScore = (nScore - nSeqAlpha * nMultSeqAlpha);
					sSeqAlpha = "- " + String.valueOf(nSeqAlpha * nMultSeqAlpha);
				}
				if (nSeqNumber > 0) {
					// Existem strings numéricas sequenciais (3 caracteres ou mais)
					nScore = (nScore - nSeqNumber * nMultSeqNumber);
					sSeqNumber = "- " + String.valueOf(nSeqNumber * nMultSeqNumber);
				}
				if (nSeqSymbol > 0) {
					// Existem strings de símbolos sequenciais (3 caracteres ou mais)
					nScore = (nScore - nSeqSymbol * nMultSeqSymbol);
					sSeqSymbol = "- " + String.valueOf(nSeqSymbol * nMultSeqSymbol);
				}
				/*
				* Determinar se os requisitos obrigatórios foram atendidos e definir indicadores de imagem
				* de acordo
				*/
				nRequirements = nReqChar;
				if (pwd.length() >= nMinPwdLen) {
					nMinReqChars = 3;
				} else {
					nMinReqChars = 4;
				}
				if (nRequirements > nMinReqChars) {
					//Existem um ou mais caracteres obrigatórios
					nScore = (nScore + nRequirements * 2);
					sRequirements = "+ " + String.valueOf(nRequirements * 2);
				}

				/* Determina a complexidade com base na pontuação geral */
				if (nScore > 100) {
					nScore = 100;
				} else if (nScore < 0) {
					nScore = 0;
				}
				if (nScore >= 0 && nScore < 20) {
					sComplexity = "Muito fraca";
				} else if (nScore >= 20 && nScore < 40) {
					sComplexity = "Fraca";
				} else if (nScore >= 40 && nScore < 60) {
					sComplexity = "Bom";
				} else if (nScore >= 60 && nScore < 80) {
					sComplexity = "Forte";
				} else if (nScore >= 80 && nScore <= 100) {
					sComplexity = "Muito forte";
				}

				vScore = String.valueOf(nScore) + "%";
				vComplexity = sComplexity;
				
				resultPassword =  new ResultPasswordDTO(vScore, vComplexity);
			}
		}
		return resultPassword;
	}
	
	public static String encoder(String pValor) {
	    return new String(Base64.getEncoder().encode(pValor.getBytes()));
	}
	
	public static String decoder(String pValor) {
	    return new String(Base64.getDecoder().decode(pValor.getBytes()));
	}
}
