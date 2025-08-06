from py.lib import *

a = []
b = []
c = []

while True:
    print("\nDigite as dimensões da Matriz A.")
    linA, colA = dimMatriz()
    print("\nDigite as dimensões da Matriz B.")
    linB, colB = dimMatriz()

    MatQuad(linA, colA, linB, colB)

    if (colA != linB):   #Verifica se o num de colunas de A é igual ao num de linhas de B para poder multiplicar
        print('Não é possível multiplicar!')
        print("O número de colunas da Matriz A é diferente do número de linhas da Matriz B.\n")
    else:
        print("\nDigite os valores da matriz A:")
        inserirValores(a, linA, colA)
        print("\nDigite os valores da matriz B:")
        inserirValores(b, linB, colB)

        print("Matriz A:")
        exibirMatriz(a, linA, colA)
        print("Matriz B:")
        exibirMatriz(b, linB, colB)

        c = multiplicarMatriz(a, b, linA, colB)
        mostrarCalc(a, b, linA, colB, colA)
        print("Matriz C:")
        exibirMatriz(c, linA, colB)
        break