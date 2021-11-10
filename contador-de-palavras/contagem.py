#-*- coding: utf-8 -*-
'''
Requisitos
nltk - biblioteca utilizada para quebrar o texto e gerar os tokens
sudo pip install -U nltk

>>> ntk.download('punkt')

'''


import nltk

simbolos_para_remover = ['...',',','.', '~', '^', '´', '`', '+','[', ']', '-', '&','_', 
	'=',  ';', ':', '(', ')', '{', '}', '!','/', '?', '"','\n','']


#Faz o treinamento com a base de dados
def contar_dados(data):
	lista_tokens = []
	for email in data:
		email = email.lower()
		tokens = nltk.word_tokenize(email)
		lista_tokens.append(tokens)

	#Retira as stopwords e as pontuações
	lista_tokens = remover_inuteis(lista_tokens)
	frequencia_tokens = calcular_frequencia_palavras(lista_tokens)
	return frequencia_tokens

#Retira as stopwords e as pontuações
def remover_inuteis(lista_palavras):
	palavras = []
	for e in lista_palavras:
		for str in e:
			if len(str)> 2 and not str in simbolos_para_remover:
				palavras.append(str)

	return palavras

#Calcula a frequencia
def calcular_frequencia_palavras(data):
	lista=[]

	for palavra in data:
		state = True
		info = []
		for j in range(len(lista)):
			if(palavra==lista[j][0]):
				state = False
				break
		if(state):
			count = 0
			for i in range(len(data)):
				if palavra==data[i]:
					count +=1
			
			info.append(palavra)
			info.append(count)
			lista.append(info)

	lista = ordenar(lista)
	return lista

#Ordena do maior para o menor
def ordenar(lista):
	lista.sort(key=lambda x: x[1])
	lista.reverse()
	return lista


###########
# INICIO ##
###########
def main():

	print("Iniciando contagem")
	arq = open('base de dados_aaa.txt', 'r',encoding='utf-8', errors='ignore')
	data = arq.readlines()
	arq.close()

	#Faz a contagem das palavras 
	freq_tokens = contar_dados(data)

	print(freq_tokens)

	
	



	
main()