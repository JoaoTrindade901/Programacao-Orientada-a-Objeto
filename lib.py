def dimMatriz():
    while True:
        try:
            lin = int(input("Linhas: "))
            col = int(input("Colunas: "))  #Define a dimensão de da matriz e retorna o valor LinXCol
        except ValueError:
            print("Valores inválidos! Digite as dimensões da Matriz novamente.\n")
        else:
            return lin, col

def iniciaMatriz(x, linX, colX):
    for i in range(linX):
        linha = []
        for j in range(colX):
            linha.append(0)
        x.append(linha)     #Inicia qualquer matriz com 0 não dar erro de index

def inserirValores(x, linX, colX):
    for i in range(linX):
        while True:
            linha = []
            try:
                for j in range(colX):
                    valor = int(input(f"M{i +1}{j+1}: "))
                    linha.append(valor)
            except ValueError:
                print("Valor inválido! Digite a linha novamente.")
                continue
            else:
                x.append(linha)
                break
    print()  #Insere os valores na matriz perguntando o valor para o usuário

def exibirMatriz(x, linX, colX):
    for i in range(linX):
        for j in range(colX):
            print(f'{x[i][j]}', end='  ')
        print()
    print()   #Exibe a matriz

def multiplicarMatriz(x, y, linX, colY, linY):
    c = []
    iniciaMatriz(c, linX, colY)
    for i in range(linX):
        for j in range(colY):
            for k in range(linY):
                c[i][j] += x[i][k] * y[k][j]

    return c   #Realiza a multiplicação de duas matrizes

def MatQuad(linX, colX, linY, colY):
    if (linX == colX) and (linY == colY):
        print(f"As matrizes SÃO quadradas.")
    elif (linX == colX) and (linY != colY):
        print("Somente a Matriz A é quadrada.")
    elif (linX != colX) and (linY == colY):
        print("Somente a Matriz B é quadrada.")
    else:
        print("As matrizes NÃO SÃO quadradas.")  #Verifica se as matrizes são quadradas

def somaNum(a, b):
    return a+b
def multiNum(a, b):
    return  a*b

def mostrarCalc(x, y, linX, colY, colX):
    print("PROCESSO DE CÁLCULO:")
    for i in range(linX):
        for j in range(colY):
            termos = []
            soma = 0
            for k in range(colX):
                termo = multiNum(x[i][k], y[k][j])
                termos.append(f"{x[i][k]}·{y[k][j]}")
                soma = somaNum(soma, termo)
            parte_mult = " + ".join(termos)
            parte_valores = " + ".join([str(multiNum(x[i][k], y[k][j])) for k in range(colX)])
            print(f"C{i+1}{j+1} = {parte_mult} = {parte_valores} = {soma}")
    print()