#Proyecto #1 taller de programacion
#Autor: Daniel Alpizar Batista

import os 
import re 
import pdfkit
import webbrowser

#Codigos de ISO 3166-1 alpha-3 de los paises de centroamerica
#Belice: BLZ
#Costa Rica: CRI
#El Salvador: SLV
#Guatemala: GTM
#Honduras: HND
#Nicaragua: NIC
#Panama: PAN
#Mexico: MEX
codigospaises = ["BLZ","CRI","SLV","GTM","HND","NIC","PAN","MEX"]
nombrespaises = ["Belice","Costa Rica","El Salvador","Guatemala","Honduras","Nicaragua","Panama","Mexico"]

#Lista utilizada para todas las funciones
disciplinas = []
#Categorias existentes
categorias = ("U12", "U13", "U14", "U15", "U16", "U17", "U18", "U20", "MAYOR", "MASTER")
#Lista de las pruebas por disciplina 
pruebas = []
#Lista de atletas
atletas = []
#Lista de eventos
eventos = []
#Lista de marcas por evento
marcas_por_evento = []

#Funcion que valida si un elemento esta en una matrizc
def esta(elemento,lista):
    for a in lista: #Validar que la disciplina no este en la lista
        if elemento in a:
            return True
    return False


#Funcion de clear para mas organizacion en la interfaz de usuario
def clear():
    if os.name == "nt":
        os.system("cls")
    else:
        os.system("clear")

#Funcion que verifica si un correo es valido
def validar_correo(email):
    patron = re.compile(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')
    if not patron.match(email):
        return False
    return True

#Funcion que ordena las marcas de la lista de marcas
def ordenar(marcas):
    listamarcas = []
    for i in marcas[1:]:
        for j in pruebas:
            if i[0] == j[0]:
                disciplina = j[4]
                break
            else:
                disciplina = None
        if disciplina == None:
            return
        for a in disciplinas:
            if a[0] == disciplina:
                medicion = a[1]
                break
        if medicion == "T":
            listamarcas.append([])
            for a in i[1:]:
                listamarcas[len(listamarcas)-1].append(a[2])
            listamarcas[len(listamarcas)-1].sort()
        if medicion == "M":
            listamarcas.append([])
            for a in i[1:]:
                listamarcas[len(listamarcas)-1].append(a[2])
            listamarcas[len(listamarcas)-1].sort()
            listamarcas[len(listamarcas)-1].reverse()
    return listamarcas

#Funcion #1 - Registrar disciplinas

#Funcion que agrega una disciplina a la lista de disciplinas 
#ENTRADAS: Nombre y forma de medir de la disciplina que se quiere agregar, lista de las disciplinas
#SALIDAS: Agrega la disciplina a la lista de disciplinas
def agregar_disciplinas(lista):
    nombre = 1
    while nombre != "C":
        print("")
        print("EVENTOS DE ATLETISMO")
        print("AGREGAR DISCIPLINAS")
        nombre = input("Nombre de la disciplina: ")
        if nombre == "C":
            return
        while True:
            if len(nombre) > 30 or len(nombre) < 5:
                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                nombre = input("Nombre de la disciplina: ")
                if nombre == "C":
                    return
            else:
                break
        if nombre == "C":
            return
        while esta(nombre,lista) == True:
            print("ESTA DISCIPLINA YA ESTÁ REGISTRADA, NO SE PUEDE AGREGAR")
            nombre = input("Nombre de la disciplina: ")
            if nombre == "C":
                return
        medida = input("Forma de medir (T/M): ")
        while True:
            if medida == "T" or medida == "M":
                break
            else:
                print("ERROR: las formas de medida son T o M")
                medida = input("Forma de medir (T/M): ")

        opcion = input("OPCION: <C> CANCELAR <A> ACEPTAR: ")
        while True:
            if opcion == "A" or opcion == "C":
                match opcion:
                    case "C":
                        print("La disciplina no ha sido agraegada")
                        break
                    case "A":
                        lista.append((nombre,medida))  
                        print("La disciplina ha sido agregada")
                        break
            else:
                print("Digite una opcion valida")
                opcion = input("OPCION: <C> CANCELAR <A> ACEPTAR: ")

#Funcion que consulta la lista de disciplinas 
#ENTRADAS: Nombre de la disciplina que se quiere consultar, lista de las disciplinas
#SALIDAS: Informacion de la disciplina consultada    
def consultar_disciplinas(lista):
    nombre = ""
    while nombre != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("CONSULTAR DISCIPLINAS")
        nombre = input("Nombre de la disciplina: ")
        if nombre == "C":
            return
        while True:
            if len(nombre) > 30 or len(nombre) < 5:
                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                nombre = input("Nombre de la disciplina: ")
                if nombre == "C":
                    return
            else:
                break
        if nombre == "C":
            return
        while var == False:
            if esta(nombre,lista) == True:
                for elemento in lista:
                    if nombre in elemento:
                        print("Forma de medir: ",elemento[1])
                        var = True
            else:
                print("ESTA DISCIPLINA NO ESTA REGISTRADA, NO SE PUEDE CONSULTAR")
                nombre = input("Nombre de la disciplina: ")
                if nombre == "C":
                    return
        opcion = input("<A> ACEPTAR: ")
        while True:
            if opcion == "A":
                break
            else:
                print("Digite una opcion valida")
                opcion = input("<A> ACEPTAR: ")

#Funcion que modifica una disciplina de la lista de disciplinas 
#ENTRADAS: Nombre de la disciplina que se quiere modificar, nombre y forma de medir nuevas, lista de las disciplinas
#SALIDAS: Modifica una disciplina de la lista de disciplinas 
def modificar_disciplinas(lista):
    nombre = ""
    while nombre != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("MODIFICAR DISCIPLINAS")
        nombre = input("Nombre de la disciplina: ")
        if nombre == "C":
            return
        while True:
            if len(nombre) > 30 or len(nombre) < 5:
                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                nombre = input("Nombre de la disciplina: ")
                if nombre == "C":
                    return
            else:
                break
        if nombre == "C":
            return
        while var == False:
            if esta(nombre,lista) == True:
                for elemento in lista:
                    if nombre in elemento:
                        nuevonombre = input("NOMBRE MODIFICADO: ")
                        if nombre == "C":
                            return
                        while True:
                            if len(nombre) > 30 or len(nombre) < 5:
                                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                                nombre = input("Nombre de la disciplina: ")
                                if nombre == "C":
                                    return
                            else:
                                break
                        print("Forma de medir: ",elemento[1])
                        nuevamedida = input("FORMA MODIFICADA: ")
                        while True:
                            if medida == "T" or medida == "M":
                                break
                            else:
                                print("ERROR: las formas de medida son T o M")
                                medida = input("Forma de medir (T/M): ")
                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        while True:
                            if opcion == "A" or opcion == "C":
                                break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        if opcion == "A":
                            if nuevonombre != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][0] = nuevonombre
                                elemento = list(elemento)
                                elemento[0] = nuevonombre
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                            if nuevamedida != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][1] = nuevamedida
                                elemento = list(elemento)
                                elemento[1] = nuevamedida
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                        var = True
            else:
                print("ESTA DISCIPLINA NO ESTA REGISTRADA, NO SE PUEDE MODIFICAR")
                nombre = input("Nombre de la disciplina: ")
                while True:
                    if len(nombre) > 30 or len(nombre) < 5:
                        print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                        nombre = input("Nombre de la disciplina: ")
                        if nombre == "C":
                            return
                    else:
                        break
                if nombre == "C":
                    return
                
#Funcion que elimina una disciplina de la lista de disciplinas 
#ENTRADAS: Nombre de la disciplina que se quiere eliminar, lista de las disciplinas
#SALIDAS: Elimina una disciplina de la lista de disciplinas
def eliminar_disciplinas(lista):
    nombre = ""
    while nombre != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("ELIMINAR DISCIPLINAS")
        nombre = input("Nombre de la disciplina: ")
        if nombre == "C":
            return
        while True:
            if len(nombre) > 30 or len(nombre) < 5:
                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                nombre = input("Nombre de la disciplina: ")
                if nombre == "C":
                    return
            else:
                break
        if nombre == "C":
            return
        while var == False:
            if esta(nombre,lista) == True:
                for elemento in lista:
                    if nombre in elemento:
                        print("Forma de medir: ",elemento[1])
                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        while True:
                            if opcion == "A" or opcion == "C":
                                break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        if opcion == "A":
                            lista[lista.index(elemento)] = list(elemento)
                            elemento = list(elemento)
                            del lista[lista.index(elemento)]
                        var = True
            else:
                print("ESTA DISCIPLINA NO ESTA REGISTRADA, NO SE PUEDE ELIMINAR")
                nombre = input("Nombre de la disciplina: ")
                if nombre == "C":
                    return


#Funcion #2 - Registrar pruebas por disciplina

#Funcion que agrega una prueba a la lista de pruebas
#ENTRADAS: Codigo de la prueba, nombre de la prueba, categoria de la prueba, sexo de la prueba, nombre de la disciplina, lista de las pruebas
#SALIDAS: Agrega una prueba a la lista de pruebas
def agregar_pruebas(lista,categorias,listadisciplinas):
    codigo = ""
    while codigo != "C":
        print("")
        print("EVENTOS DE ATLETISMO")
        print("AGREGAR PRUEBAS")
        codigo = input("Codigo de la prueba: ")
        if codigo == "C":
            return
        while True:
            if len(codigo) != 3:
                print("ERROR: El codigo tiene que tener 3 caracteres")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return
            else:
                break
        if codigo == "C":
            return
        while esta(codigo,lista) == True:
            print("ESTA PRUEBA YA ESTÁ REGISTRADA, NO SEPUEDE AGREGAR")
            codigo = input("Nombre de la disciplina: ")
            if codigo == "C":
                return
        nombreprueba = input("Digite el nombre de la prueba: ")
        while True:
            if len(nombreprueba) > 30 or len(nombreprueba) < 5:
                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                nombreprueba = input("Digite el nombre de la prueba: ")
            else:
                break
        categoria = input("Digite la categoria de la prueba: ")
        while True:
            if categoria not in categorias:
                print("ERROR: La categoria tiene que estar dentro de las categorias permitidas")
                categoria = input("Digite la categoria de la prueba: ")
            else:
                break
        sexo = input("Digite sexo (M/F): ")
        while True:
            if sexo == "M" or sexo == "F":
                break
            else:
                print("ERROR: El sexo tiene que ser M o F")
                sexo = input("Digite sexo (M/F): ")
        nombredisciplina = input("Digite el nombre de la disciplina: ")
        while True:
            if len(nombredisciplina) > 30 or len(nombredisciplina) < 5:
                print("ERROR: El nombre tiene que tener menos de 30 caracteres y mas de 5")
                nombredisciplina = input("Nombre de la disciplina: ")
            else:
                break
        var = False
        si = False
        while var == False:
            for i in listadisciplinas:
                if nombredisciplina in i:
                    var = True
                    si = True
                else:
                    pass
            if si == False:
                print("ERROR: La disciplina no esta registrada")
                nombredisciplina = input("Nombre de la disciplina: ")
        opcion = input("OPCION: <C> CANCELAR <A> ACEPTAR: ")
        while True:
            if opcion == "A" or opcion == "C":
                match opcion:
                    case "C":
                        print("La prueba no ha sido agraegada")
                        break
                    case "A":
                        lista.append((codigo,nombreprueba,categoria,sexo,nombredisciplina))  
                        print("La prueba ha sido agregada")
                        break
            else:
                print("Digite una opcion valida")
                opcion = input("OPCION: <C> CANCELAR <A> ACEPTAR: ")

#Funcion que consulta una prueba de la lista de pruebas
#ENTRADAS: codigo de la prueba, lista de las pruebas
#SALIDAS: Informacion de la prueba consultada
def consultar_pruebas(lista):
    codigo = ""
    while codigo != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("CONSULTAR PRUEBAS")
        codigo = input("Codigo de la prueba: ")
        if codigo == "C":
            return
        while True:
            if len(codigo) == 2:
                print("ERROR: El codigo tiene que tener 3 caracteres")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return
            else:
                break
        if codigo == "C":
            return
        while esta(codigo,lista) == False:
            print("ESTA PRUEBA NO ESTA REGISTRADA, NO SE PUEDE CONSULTAR")
            codigo = input("Codigo de la prueba: ")
            if codigo == "C":
                return
        while var == False:
            if esta(codigo,lista) == True:
                for elemento in lista:
                    if codigo in elemento:
                        print("Nombre de la prueba: ",elemento[1])
                        print("Categoría: ",elemento[2])
                        print("Sexo (F/M): ",elemento[3])
                        print("Nombre de la disciplina: ",elemento[4])
                        var = True
            else:
                print("ESTA PRUEBA NO ESTA REGISTRADA, NO SE PUEDE CONSULTAR")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return
        opcion = input("<A> ACEPTAR: ")
        while True:
            if opcion == "A":
                break
            else:
                print("Digite una opcion valida")
                opcion = input("<A> ACEPTAR: ")

#Funcion que modifica una prueba de la lista de pruebas
#ENTRADAS: codigo de la prueba, nuevo codigo de la prueba, nuevo nombre de la prueba, nueva categoria de la prueba, nuevo sexo, nuevo nombre de la disciplina, lista de las pruebas
#SALIDAS: Modifica una prueba de la lista de pruebas
def modificar_pruebas(lista):
    codigo = ""
    while codigo != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("MODIFICAR PRUEBAS")
        codigo = input("Codigo de la prueba: ")
        if codigo == "C":
            return
        while True:
            if len(codigo) == 2:
                print("ERROR: El codigo tiene que tener 3 caracteres")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return
            else:
                break
        if codigo == "C":
            return
        while esta(codigo,lista) == False:
            print("ESTA PRUEBA NO ESTA REGISTRADA, NO SE PUEDE CONSULTAR")
            codigo = input("Codigo de la prueba: ")
            if codigo == "C":
                return
        while var == False:
            if esta(codigo,lista) == True:
                for elemento in lista:
                    if codigo in elemento:
                        nuevocodigo = input("CODIGO MODIFICADO: ")
                        print("Nombre de la prueba: ",elemento[1])
                        nuevonombre = input("NOMBRE MODIFICADO: ")
                        print("Categoria de la prueba: ",elemento[2])
                        nuevacategoria = input("CATEGORIA MODIFICADA: ")
                        print("Sexo (M/F): ",elemento[3])
                        nuevosexo = input("SEXO MODIFICADO: ")
                        print("Nombre de la disciplina: ",elemento[4])
                        nuevadisciplina = input("DISCIPLINA MODIFICADA: ")
                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        while True:
                            if opcion == "A" or opcion == "C":
                                break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        if opcion == "A":
                            if nuevocodigo != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][0] = nuevocodigo
                                elemento = list(elemento)
                                elemento[0] = nuevocodigo
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                            if nuevonombre != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][1] = nuevonombre
                                elemento = list(elemento)
                                elemento[1] = nuevonombre
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                            if nuevacategoria != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][2] = nuevacategoria
                                elemento = list(elemento)
                                elemento[2] = nuevacategoria
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                            if nuevosexo != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][3] = nuevosexo
                                elemento = list(elemento)
                                elemento[3] = nuevosexo
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                            if nuevadisciplina != "":
                                lista[lista.index(elemento)] = list(elemento)
                                lista[lista.index(list(elemento))][4] = nuevadisciplina
                                elemento = list(elemento)
                                elemento[4] = nuevadisciplina
                                lista[lista.index(list(elemento))] = tuple(elemento)
                                elemento = tuple(elemento)
                        var = True
            else:
                print("ESTA PRUEBA NO ESTA REGISTRADA, NO SE PUEDE MODIFICAR")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return

#Funcion que elimina una prueba de la lista de pruebas
#ENTRADAS: codigo de la prueba, lista de las pruebas
#SALIDAS: Elimina una prueba de la lista de pruebas
def eliminar_pruebas(lista):
    codigo = ""
    while codigo != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("ELIMINAR PRUEBAS")
        codigo = input("Codigo de la prueba: ")
        if codigo == "C":
            return
        while True:
            if len(codigo) == 2:
                print("ERROR: El codigo tiene que tener 3 caracteres")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return
            else:
                break
        if codigo == "C":
            return
        while var == False:
            if esta(codigo,lista) == True:
                for elemento in lista:
                    if codigo in elemento:
                        print("Nombre de la prueba: ",elemento[1])
                        print("Categoría: ",elemento[2])
                        print("Sexo (F/M): ",elemento[3])
                        print("Nombre de la disciplina: ",elemento[4])
                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        while True:
                            if opcion == "A" or opcion == "C":
                                break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        if opcion == "A":
                            lista[lista.index(elemento)] = list(elemento)
                            elemento = list(elemento)
                            del lista[lista.index(elemento)]
                        var = True
            else:
                print("ESTA PRUEBA NO ESTA REGISTRADA, NO SE PUEDE ELIMINAR")
                codigo = input("Codigo de la prueba: ")
                if codigo == "C":
                    return

#Funcion #3 - Registrar atletas

#Funcion que agrega atletas a la lista de atletasta
#ENTRADAS: identificacion del atleta, nombre del atleta, primer apellido del atleta, segundo apellido del atleta , sexo del atleta, pais que representa el atleta, fecha de nacimiento del atleta, correo electronico del atleta, telefono del atleta, lista de atletas
#SALIDAS: Agrega atletas a la lista de atletas
def agregar_atletas(lista):
    identificacion = ""
    while identificacion != "C":
        print("")
        print("EVENTOS DE ATLETISMO")
        print("AGREGAR ATLETAS")
        identificacion = input("Identificacion del atleta: ")
        if identificacion == "C":
            return
        while True:
            if len(identificacion) > 20 or len(identificacion) < 9:
                print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                identificacion = input("Identificacion del atleta: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while esta(identificacion,lista) == True:
            print("ESTE ATLETA YA ESTÁ REGISTRADO, NO SE PUEDE AGREGAR")
            identificacion = input("Identificacion del atleta: ")
            if identificacion == "C":
                return "C"
        nombreatleta = input("Nombre del atleta: ")
        while True:
            if len(nombreatleta) > 20 or len(nombreatleta) < 2:
                print("ERROR: El nombre tiene que tener entre 2 y 20 caracteres")
                nombreatleta = input("Nombre del atleta: ")
            else:
                break
        apellido1 = input("Primer apellido del atleta: ")
        while True:
            if len(apellido1) > 20 or len(apellido1) < 2:
                print("ERROR: El apellido tiene que tener entre 2 y 20 caracteres")
                apellido1 = input("Primer apellido del atleta: ")
            else:
                break
        apellido2 = input("Segundo apellido del atleta: ")
        while True:
            if len(apellido2) > 20 or len(apellido2) < 2:
                print("ERROR: El apellido tiene que tener entre 2 y 20 caracteres")
                apellido2 = input("Segundo apellido del atleta: ")
            else:
                break
        sexo = input("Sexo (F/M): ")
        while True:
            if sexo == "F" or sexo == "M":
                break
            else:
                print("El sexo tiene que ser F o M")
                sexo = input("Sexo (F/M): ")
        pais = input("Pais que representa: ")
        while True:
            if pais not in codigospaises:
                print("ERROR: El pais tiene que tener 3 caracteres y ser valido")
                pais = input("Pais que representa: ")
            else:
                break
        fecha = input("Fecha de nacimiento (ddmmaaaa): ")
        while True:
            if len(fecha) == 8:
                break
            else:
                print("ERROR: La fecha tiene que tener 8 caracteres")
                fecha = input("Fecha de nacimiento (ddmmaaaa): ")
        correo = input("Correo electronico: ")
        while True:
            if validar_correo(correo) == True:
                break
            else:
                print("ERROR: El correo electronico no es valido")
                correo = input("Correo electronico: ")
        telefono = input("Telefono: ")
        while True:
            if len(telefono) > 20 or len(telefono) < 7:
                print("ERROR: El telefono tiene que tener entre 20 caracteres y 7 caracteres")
                telefono = input("Telefono: ")
            else:
                break
        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
        while True:
            if opcion == "A" or opcion == "C":
                match opcion:
                    case "A":
                        lista.append((identificacion,nombreatleta,apellido1,apellido2,sexo,pais,fecha,correo,telefono))
                        print("El atleta se ha agregado")
                        break
                    case "C":
                        print("El atlenta no se ha agregado")
                        break
            else:
                print("Digite una opcion valida")
                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")

#Funcion que valida si un atleta esta en la lista de atletas
#ENTRADAS: identificacion del atleta, lista de atletas
#SALIDAS: Informacion del atleta
def consultar_atletas(lista):
    identificacion = ""
    while identificacion != "C":
        print("")
        print("EVENTOS DE ATLETISMO")
        print("CONSULTAR ATLETAS")
        identificacion = input("Identificacion del atleta: ")
        if identificacion == "C":
            return
        while True:
            if len(identificacion) > 20 or len(identificacion) < 9:
                print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                identificacion = input("Identificacion del atleta: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while esta(identificacion,lista) == False:
            print("ESTE ATLETA NO ESTÁ REGISTRADO, NO SE PUEDE CONSULTAR")
            identificacion = input("Identificacion del atleta: ")
            if identificacion == "C":
                return
        for elemento in lista:
            if identificacion in elemento:
                print("Nombre del atleta: ",elemento[1])
                print("Primer apellido del atleta: ",elemento[2])
                print("Segundo apellido del atleta: ",elemento[3])
                print("Sexo (F/M): ",elemento[4])
                print("Pais que representa: ",elemento[5])
                print("Fecha de nacimiento (ddmmaaaa): ",elemento[6])
                print("Correo electronico: ",elemento[7])
                print("Telefono: ",elemento[8])
                break
        opcion = input("<A> ACEPTAR: ")
        while True:
            if opcion == "A":
                break
            else:
                print("Digite una opcion valida")
                opcion = input("<A> ACEPTAR: ")
        
#Funcion que modifica un atleta de la lista de atletas
#ENTRADAS: identificacion del atleta, nueva idenificacion, nuevo nombre, nuevo primer apellido, nuevo segundo apellido, nuevo sexo, nuevo pais, nueva fecha de nacimiento, nuevo correo electronico, nuevo telefono, lista de atletas
#SALIDAS: Informacion del atleta modificada
def modificar_atletas(lista):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("MODIFICAR ATLETAS")
        identificacion = input("Identificacion del atleta: ")
        if identificacion == "C":
            return
        while True:
            if len(identificacion) > 20 or len(identificacion) < 9:
                print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                identificacion = input("Identificacion del atleta: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while esta(identificacion,lista) == False:
            print("ESTE ATLETA NO ESTÁ REGISTRADO, NO SE PUEDE MODIFICAR")
            identificacion = input("Identificacion del atleta: ")
            if identificacion == "C":
                return
        while var == False:
            for elemento in lista:
                if identificacion in elemento:
                    nuevaidentificacion = input("IENTIFICACION MODIFICADA: ")
                    print("Nombre del atleta: ",elemento[1])
                    nuevonombre = input("NOMBRE DEL ATLETA MODIFICADO: ")
                    print("Primer apellido del atleta: ",elemento[2])
                    nuevoapellido1 = input("PRIMER APELLIDO DEL ATLETA MODIFICADO: ")
                    print("Segundo apellido del atleta: ",elemento[3])
                    nuevoapellido2 = input("SEGUNDO APELLIDO DEL ATLETA MODIFICADO: ")
                    print("Sexo (F/M): ",elemento[4])
                    nuevosexo = input("SEXO MODIFICADO (F/M): ")
                    print("Pais que representa: ",elemento[5])
                    nuevopais = input("PAIS QUE REPRESENTA MODIFICADO: ")
                    print("Fecha de nacimiento (ddmmaaaa): ",elemento[6])
                    nuevafecha = input("FECHA DE NACIMIENTO MODIFICADA (ddmmaaaa): ")
                    print("Correo electronico: ",elemento[7])
                    nuevocorreo = input("CORREO ELECTRONICO MODIFICADO: ")
                    print("Telefono: ",elemento[8])
                    nuevotelefono = input("TELEFONO MODIFICADO: ")
                    opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                    while True:
                            if opcion == "A" or opcion == "C":
                                break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                    if opcion == "A":
                        if nuevaidentificacion != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][0] = nuevaidentificacion
                            elemento = list(elemento)
                            elemento[0] = nuevaidentificacion
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevonombre != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][1] = nuevonombre
                            elemento = list(elemento)
                            elemento[1] = nuevonombre
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevoapellido1 != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][2] = nuevoapellido1
                            elemento = list(elemento)
                            elemento[2] = nuevoapellido1
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevoapellido2 != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][3] = nuevoapellido2
                            elemento = list(elemento)
                            elemento[3] = nuevoapellido2
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevosexo != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][4] = nuevosexo
                            elemento = list(elemento)
                            elemento[4] = nuevosexo
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevopais != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][5] = nuevopais
                            elemento = list(elemento)
                            elemento[5] = nuevopais
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevafecha != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][6] = nuevafecha
                            elemento = list(elemento)
                            elemento[6] = nuevafecha
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevocorreo != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][7] = nuevocorreo
                            elemento = list(elemento)
                            elemento[7] = nuevocorreo
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevotelefono != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][8] = nuevotelefono
                            elemento = list(elemento)
                            elemento[8] = nuevotelefono
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                    var = True

#Funcion que elimina atletas de la lista de atletas
#Entrada: identificacion del atleta, lista de atletas
#Salida: elimina el atleta de la lista de atletas
def eliminar_atletas(lista):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("ELIMINAR ATLETAS")
        identificacion = input("Identificacion del atleta: ")
        if identificacion == "C":
            return
        while True:
            if len(identificacion) > 20 or len(identificacion) < 9:
                print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                identificacion = input("Identificacion del atleta: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while var == False:
            if esta(identificacion,lista) == True:
                for elemento in lista:
                    if identificacion in elemento:
                        print("Nombre del atleta: ",elemento[1])
                        print("Primer apellido del atleta: ",elemento[2])
                        print("Segundo apellido del atleta: ",elemento[3])
                        print("Sexo (F/M): ",elemento[4])
                        print("Pais que representa: ",elemento[5])
                        print("Fecha de nacimiento (ddmmaaaa): ",elemento[6])
                        print("Correo electronico: ",elemento[7])
                        print("Telefono: ",elemento[8])
                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        while True:
                            if opcion == "A" or opcion == "C":
                                break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        if opcion == "A":
                            lista[lista.index(elemento)] = list(elemento)
                            elemento = list(elemento)
                            del lista[lista.index(elemento)]
                        var = True
            else:
                print("ESTE ATLETA NO ESTÁ REGISTRADO, NO SE PUEDE CONSULTAR")
                identificacion = input("Identificacion del atleta: ")
                if identificacion == "C":
                    return



#Funcion #4 - Registrar eventos

#Funcion que agrega eventos a la lista de eventos
#ENTRADAS: identificacion del evento, nombre del evento, pais anfitrion del evento, luar del evento, fecha inicial del evento, fecha final del evento, lista de eventos
#SALIDAS: agrega el evento a la lista de eventos
def agregar_eventos(lista):
    identificacion = ""
    while identificacion != "C":
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("AGREGAR EVENTOS")
        identificacion = input("Identificacion del evento: ")
        if identificacion == "C":
            return
        while True:
            if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while esta(identificacion,lista) == True:
            print("ESTE EVENTO YA ESTÁ REGISTRADO, NO SE PUEDE AGREGAR")
            identificacion = input("Identificacion del evento: ")
            if identificacion == "C":
                return
        nombre = input("Nombre del evento: ")
        while True:
            if len(nombre) > 60 or len(nombre) < 5:
                print("ERROR: El nombre tiene que tener entre 5 y 60 caracteres")
                nombre = input("Nombre del evento: ")
                if nombre == "C":
                    return
            else:
                break
        pais = input("Pais anfitrion del evento: ")
        while True:
            if pais not in nombrespaises:
                print("ERROR: El pais tiene que ser valido")
                pais = input("Pais anfitrion del evento: ")
            else:
                break
        lugar = input("Lugar del evento: ")
        while True:
            if len(lugar) > 60 or len(lugar) < 5:
                print("ERROR: El lugar tiene que tener entre 5 y 60 caracteres")
                lugar = input("Lugar del evento: ")
                if lugar == "C":
                    return
            else:
                break
        fecha1 = input("Fecha inicial del evento (ddmmaaaa): ")
        while True:
            if len(fecha1) != 8:
                print("ERROR: La fecha tiene que tener 8 caracteres")
                fecha1 = input("Fecha inicial del evento (ddmmaaaa): ")
            else:
                break
        fecha2 = input("Fecha final del evento (ddmmaaaa): ")
        while True:
            if len(fecha2) != 8:
                print("ERROR: La fecha tiene que tener 8 caracteres")
                fecha2 = input("Fecha final del evento (ddmmaaaa): ")
            else:
                break
        while True:
            if fecha1 > fecha2:
                print("ERROR: La fecha inicial tiene que ser menor a la fecha final")
                fecha1 = input("Fecha inicial del evento (ddmmaaaa): ")
                fecha2 = input("Fecha final del evento (ddmmaaaa): ")
            else:
                break
        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
        while True:
            if opcion == "A" or opcion == "C":
                match opcion:
                    case "A":
                        lista.append([identificacion,nombre,pais,lugar,fecha1,fecha2])
                        print("El evento ha sido registrado")
                        break
                    case "C":
                        print("El evento no ha sido registrado")
                        break
            else:
                print("Digite una opcion valida")
                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")


#Funcion que consulta eventos de la lista de eventos
#ENTRADAS: identificacion del evento, lista de eventos
#SALIDAS: imprime los datos del evento
def consultar_eventos(lista):
    identificacion = ""
    while identificacion != "C":
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("CONSULTAR EVENTOS")
        identificacion = input("Identificacion del evento: ")
        if identificacion == "C":
            return
        while True:
            if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while True:
            if esta(identificacion,lista) == False:
                print("ESTE EVENTO NO ESTÁ REGISTRADO, NO SE PUEDE CONSULTAR")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        for elemento in lista:
            if identificacion in elemento:
                print("Nombre del evento: ",elemento[1])
                print("Pais anfitrion del evento: ",elemento[2])
                print("Lugar del evento: ",elemento[3])
                print("Fecha inicial del evento: ",elemento[4])
                print("Fecha final del evento: ",elemento[5])
                break
        opcion = input("<A> ACEPTAR: ")
        while True:
            if opcion == "A":
                break
            else:
                print("Digite una opcion valida")
                opcion = input("<A> ACEPTAR: ")


#Funcion que modifica eventos de la lista de eventos
#ENTRADAS: identificacion del evento, nueva identificacion del evento, nuevo nombre del evento, nuevo pais anfitrion del evento, nuevo lugar del evento, nueva fecha inicial del evento, nueva fecha final del evento, lista de eventos
#SALIDAS: modifica los datos en la lista de eventos
def modificar_eventos(lista):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("MODIFICAR EVENTOS")
        identificacion = input("Identificacion del evento: ")
        if identificacion == "C":
            return
        while True:
            if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while True:
            if esta(identificacion,lista) == False:
                print("ESTE EVENTO NO ESTÁ REGISTRADO, NO SE PUEDE MODIFICAR")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        while var == False:
            for elemento in lista:
                if identificacion in elemento:
                    nuevaidentificacion = input("IENTIFICACION MODIFICADA: ")
                    print("Nombre del evento: ",elemento[1])
                    nuevonombre = input("NOMBRE MODIFICADO: ")
                    print("Pais anfitrion del evento: ",elemento[2])
                    nuevopais = input("PAIS MODIFICADO: ")
                    print("Lugar: ",elemento[3])
                    nuevolugar = input("LUGAR MODIFICADO: ")
                    print("Fecha inicial del evento: ",elemento[4])
                    nuevafecha1 = input("FECHA INICIAL MODIFICADA: ")
                    print("Fecha final del evento: ",elemento[5])
                    nuevafecha2 = input("FECHA FINAL MODIFICADA: ")
                    opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                    while True:
                        if opcion == "A" or opcion == "C":
                                break
                        else:
                            print("Digite una opcion valida")
                            opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                    if opcion == "A":
                        if nuevaidentificacion != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][0] = nuevaidentificacion
                            elemento = list(elemento)
                            elemento[0] = nuevaidentificacion
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevonombre != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][1] = nuevonombre
                            elemento = list(elemento)
                            elemento[1] = nuevonombre
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevopais != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][2] = nuevopais
                            elemento = list(elemento)
                            elemento[2] = nuevopais
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevolugar != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][3] = nuevolugar
                            elemento = list(elemento)
                            elemento[3] = nuevolugar
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevafecha1 != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][4] = nuevafecha1
                            elemento = list(elemento)
                            elemento[4] = nuevafecha1
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                        if nuevafecha2 != "":
                            lista[lista.index(elemento)] = list(elemento)
                            lista[lista.index(list(elemento))][5] = nuevafecha2
                            elemento = list(elemento)
                            elemento[5] = nuevafecha2
                            lista[lista.index(list(elemento))] = tuple(elemento)
                            elemento = tuple(elemento)
                    var = True


#Funcion que elimina eventos de la lista de eventos
#ENTRADAS: identificacion del evento, lista de eventos
#SALIDAS: elimina el evento de la lista de eventos
def eliminar_eventos(lista):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("ELIMINAR EVENTOS")
        identificacion = input("Identificacion del evento: ")
        if identificacion == "C":
            return
        while True:
            if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        if identificacion == "C":
            return
        while True:
            if esta(identificacion,lista) == False:
                print("ESTE EVENTO NO ESTÁ REGISTRADO, NO SE PUEDE ELIMINAR")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
            else:
                break
        while var == False:
            if esta(identificacion,lista) == True:
                for elemento in lista:
                    if identificacion in elemento:
                        print("Nombre del evento: ",elemento[1])
                        print("Pais anfitrion del evento: ",elemento[2])
                        print("Lugar del evento: ",elemento[3])
                        print("Fecha inicial del evento: ",elemento[4])
                        print("Fecha final del evento: ",elemento[5])
                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        while True:
                            if opcion == "A" or opcion == "C":
                                    break
                            else:
                                print("Digite una opcion valida")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                        if opcion == "A":
                            lista[lista.index(elemento)] = list(elemento)
                            elemento = list(elemento)
                            del lista[lista.index(elemento)]
                        var = True
            else:
                print("ESTE EVENTO NO ESTÁ REGISTRADO, NO SE PUEDE ELIMINAR")
                identificacion = input("Identificacion del evento: ")
                if identificacion == "C":
                    return
                


#Funcion #5 - Registrar marcas

#Funcion que agrega marcas a la lista de marcas
#ENTRADAS: lista de eventos, lista de pruebas, lista de atletas, lista de marcas, lista de disciplinas
#SALIDAS: agrega marcas a la lista de marcas
def agregar_marcas(listaeventos, listapruebas, listaatletas, listamarcas, listadisciplinas):
    identificacion = ""
    while identificacion != "C":
        var = False
        while var == False:
            print("")
            print("EVENTOS DE ATLETISMO")
            print("")
            print("AGREGAR MARCAS")
            identificacion = input("Identificacion del evento: ")
            if identificacion == "C":
                return
            while True:
                if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                    print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                    identificacion = input("Identificacion del evento: ")
                    if identificacion == "C":
                        return
                else:
                    break
            if identificacion == "C":
                return
            while True:
                if esta(identificacion,listaeventos) == False:
                    print("ESTE EVENTO NO ESTÁ REGISTRADO, NO SE PUEDE AGREGAR MARCAS")
                    identificacion = input("Identificacion del evento: ")
                    if identificacion == "C":
                        return
                else:
                    for i in listaeventos:
                        if identificacion in i:
                            print("Nombre del evento: ",i[1])
                            break
                    break
            codigo = input("Codigo de la prueba: ")
            while True:
                if len(codigo) != 3:
                    print("ERROR: El codigo tiene que tener 3 caracteres")
                    codigo = input("Codigo de la prueba: ")
                else:
                    break
            while True:
                if esta(codigo,listapruebas) == False:
                    print("ESTA PRUEBA NO ESTÁ REGISTRADA, NO SE PUEDE AGREGAR MARCAS")
                    codigo = input("Codigo de la prueba: ")
                else:
                    for i in listapruebas:
                        if codigo in i:
                            print("Nombre de la prueba: ",i[1]," - ",i[2]," - ",i[3])
                            nombredisciplina = i[4]
                            break
                    break
            identificacionatleta = input("Identificacion del atleta: ")
            while True:
                if len(identificacionatleta) > 20 or len(identificacionatleta) < 9:
                    print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                    identificacionatleta = input("Identificacion del atleta: ")
                else:
                    break
            while True:
                if esta(identificacionatleta,listaatletas) == False:
                    print("ESTE ATLETA NO ESTÁ REGISTRADO, NO SE PUEDE AGREGAR MARCAS")
                    identificacionatleta = input("Identificacion del atleta: ")
                else:
                    for i in listaatletas:
                        if identificacionatleta in i:
                            print("Nombre del atleta: ",i[1]," ",i[2]," ",i[3])
                            nombreatleta = i[1]
                            break
                    break
            listamarcas.insert(0,[1,[2,[5,4,6]]])
            while var == False:
                si = False
                for i in listamarcas:
                    for j in i[1:]:
                        for a in j[1:]:
                            if identificacion in i and codigo in j and identificacionatleta in a:
                                si == True
                            else:
                                pass
                if si == True:
                    print("MARCA YA ESTÁ REGISTRADA, NO SE PUEDE AGREGAR")
                else:
                    var = True
        dorsal = input("Dorsal del atleta: ")
        while var == True:
            si = False
            for i in listamarcas:
                    for j in i[1:]:
                        for a in j[1:]:
                            if dorsal in a:
                                si == True
                            else:
                                pass
            if si == True:
                print("DORSAL YA FUE SIDO ASIGNADO A OTRO ATLETA: ",nombreatleta)
                dorsal = input("Dorsal del atleta: ")
            else:
                var = False
        for i in listadisciplinas:
            if nombredisciplina in i:
                if i[1] == "M":
                    marca = input("Marca del atleta (mmmcc): ")
                    while True:
                        if len(marca) <= 5:
                            if len(marca) <= 2:
                                pass
                            elif len(marca) <= 5:
                                marca = list(marca)
                                marca.insert(-2, ".")
                                marca = "".join(marca)
                            break
                        else:
                            print("ERROR: La marca tiene que tener maximo 5 caracteres ya que se esta registrando una prueba de metros")
                            marca = input("Marca del atleta (mmmcc): ")
                elif i[1] == "T":
                    marca = input("Marca del atleta (hhmmsscc): ")
                    while True:
                        if len(marca) <= 8:
                            if len(marca) <= 2:
                                pass
                            elif len(marca) <= 4:
                                marca = list(marca)
                                marca.insert(-2, ".")
                                marca = "".join(marca)
                            elif len(marca) <= 6:
                                marca = list(marca)
                                marca.insert(-2, ".")
                                marca.insert(-5, ":")
                                marca = "".join(marca)
                            elif len(marca) <= 8:
                                marca = list(marca)
                                marca.insert(-2, ".")
                                marca.insert(-5, ":")
                                marca.insert(-8, ":")
                                marca = "".join(marca)
                            break
                        else:
                            print("ERROR: La marca tiene que tener maximo 8 caracteres ya que se esta registrando una prueba de tiempo")
                            marca = input("Marca del atleta (hhmmsscc): ")
        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
        while True:
            if opcion == "A" or opcion == "C":
                    break
            else:
                print("Digite una opcion valida")
                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
        if opcion == "A":
            listamarcas.append([identificacion,[codigo,(identificacionatleta,dorsal,marca)]])
            print("La marca se ha registrado")
        elif opcion == "C":
            print("La marca no se ha registrado")
        del listamarcas[0]
    


#Funcion para consultar marcas
#ENTRADAS: listaeventos, listapruebas, listaatletas, listamarcas
#SALIDAS: consulta de marca
def consultar_marcas(listaeventos, listapruebas, listaatletas, listamarcas):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("CONSULTAR MARCAS")
        while var == False:
            var = False
            identificacion = input("Identificacion del evento: ")
            if identificacion == "C":
                return
            while True:
                if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                    print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                    identificacion = input("Identificacion del evento: ")
                    if identificacion == "C":
                        return
                else:
                    break
            if identificacion == "C":
                return
            while True:
                if esta(identificacion,listaeventos) == True:
                    for i in listaeventos:
                        if identificacion in i:
                            nombreevento = i[1]
                            break
                    break
            codigo = input("Codigo de la prueba: ")
            while True:
                if len(codigo) != 3:
                    print("ERROR: El codigo tiene que tener 3 caracteres")
                    codigo = input("Codigo de la prueba: ")
                else:
                    break
            while True:
                if esta(codigo,listapruebas) == True:
                    for i in listapruebas:
                        if codigo in i:
                            nombreprueba = i[1]," - ",i[2]," - ",i[3]
                            nombreprueba = ''.join(nombreprueba)
                            break
                    break
            identificacionatleta = input("Identificacion del atleta: ")
            while True:
                if len(identificacionatleta) > 20 or len(identificacionatleta) < 9:
                    print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                    identificacionatleta = input("Identificacion del atleta: ")
                else:
                    break
            while True:
                if esta(identificacionatleta,listaatletas) == True:
                    for i in listaatletas:
                        if identificacionatleta in i:
                            nombreatleta = i[1]," ",i[2]," ",i[3]
                            nombreatleta = ''.join(nombreatleta)
                            break
                    break
            si = False
            for i in listamarcas:  
                    for j in i[1:]:
                        for a in j[1:]:
                            if identificacion in i and codigo in j and identificacionatleta in a:
                                dorsal = a[1]
                                marca = a[2]
                                si = True
                                var = True
                            else:
                                pass
            if si == True:
                print("Dorsal del atleta: ",dorsal)
                print("Marca del atleta: ",marca)
            else:
                print("MARCA NO ESTÁ REGISTRADA, NO SE PUEDE CONSULTAR")
        opcion = input("<A> ACEPTAR: ")
        while True:
            if opcion == "A":
                break
            else:
                print("Digite una opcion valida")
                opcion = input("<A> ACEPTAR: ")
        


#Funcion para modificar marcas
#ENTRADAS: listaeventos, listapruebas, listaatletas, listamarcas
#SALIDAS: marca modificada
def modificar_marcas(listaeventos, listapruebas, listaatletas, listamarcas):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("MODIFICAR MARCAS")
        while var == False:
            var = False
            identificacion = input("Identificacion del evento: ")
            if identificacion == "C":
                return
            while True:
                if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                    print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                    identificacion = input("Identificacion del evento: ")
                    if identificacion == "C":
                        return
                else:
                    break
            if identificacion == "C":
                return
            while True:
                if esta(identificacion,listaeventos) == True:
                    for i in listaeventos:
                        if identificacion in i:
                            nombreevento = i[1]
                            break
                    break
            codigo = input("Codigo de la prueba: ")
            while True:
                if len(codigo) != 3:
                    print("ERROR: El codigo tiene que tener 3 caracteres")
                    codigo = input("Codigo de la prueba: ")
                else:
                    break
            while True:
                if esta(codigo,listapruebas) == True:
                    for i in listapruebas:
                        if codigo in i:
                            nombreprueba = i[1]," - ",i[2]," - ",i[3]
                            nombreprueba = ''.join(nombreprueba)
                            break
                    break
            identificacionatleta = input("Identificacion del atleta: ")
            while True:
                if len(identificacionatleta) > 20 or len(identificacionatleta) < 9:
                    print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                    identificacionatleta = input("Identificacion del atleta: ")
                else:
                    break
            while True:
                if esta(identificacionatleta,listaatletas) == True:
                    for i in listaatletas:
                        if identificacionatleta in i:
                            nombreatleta = i[1]," ",i[2]," ",i[3]
                            nombreatleta = ''.join(nombreatleta)
                            break
                    break
            si = False
            for i in listamarcas:  
                    for j in i[1:]:
                        for a in j[1:]:
                            if identificacion in i and codigo in j and identificacionatleta in a:
                                si = True
                                var = True
                                print("Dorsal del atleta: ",a[1])
                                nuevodorsal = input("DORSAL MODIFICADO: ")
                                print("Marca del atleta: ",a[2])
                                nuevamarca = input("MARCA MODIFICADA: ")
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                                while True:
                                    if opcion == "A" or opcion == "C":
                                            break
                                    else:
                                        print("Digite una opcion valida")
                                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                                if opcion == "A":
                                    if nuevodorsal != "":
                                        listamarcas[listamarcas.index(i)][i.index(j)][j.index(a)] = list(a)
                                        listamarcas[listamarcas.index(i)][i.index(j)][j.index(list(a))][1] = nuevodorsal
                                        a = list(a)
                                        a[1] = nuevodorsal
                                        listamarcas[listamarcas.index(i)][i.index(j)][j.index(list(a))] = tuple(a)
                                        a = tuple(a)
                                    if nuevamarca != "":
                                        listamarcas[listamarcas.index(i)][i.index(j)][j.index(a)] = list(a)
                                        listamarcas[listamarcas.index(i)][i.index(j)][j.index(list(a))][2] = nuevamarca
                                        a = list(a)
                                        a[2] = nuevamarca
                                        listamarcas[listamarcas.index(i)][i.index(j)][j.index(list(a))] = tuple(a)
                                        a = tuple(a)
                            else:
                                pass
            if si == False:
                print("MARCA NO ESTÁ REGISTRADA, NO SE PUEDE MODIFICAR")
            

#Funcion para eliminar marcas
#ENTRADAS: listaeventos, listapruebas, listaatletas, listamarcas
#SALIDAS: marca eliminada
def eliminar_marcas(listaeventos, listapruebas, listaatletas, listamarcas):
    identificacion = ""
    while identificacion != "C":
        var = False
        print("")
        print("EVENTOS DE ATLETISMO")
        print("")
        print("ELIMINAR MARCAS")
        while var == False:
            var = False
            identificacion = input("Identificacion del evento: ")
            if identificacion == "C":
                return
            while True:
                if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                    print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                    identificacion = input("Identificacion del evento: ")
                    if identificacion == "C":
                        return
                else:
                    break
            if identificacion == "C":
                return
            while True:
                if esta(identificacion,listaeventos) == True:
                    for i in listaeventos:
                        if identificacion in i:
                            nombreevento = i[1]
                            break
                    break
            codigo = input("Codigo de la prueba: ")
            while True:
                if len(codigo) != 3:
                    print("ERROR: El codigo tiene que tener 3 caracteres")
                    codigo = input("Codigo de la prueba: ")
                else:
                    break
            while True:
                if esta(codigo,listapruebas) == True:
                    for i in listapruebas:
                        if codigo in i:
                            nombreprueba = i[1]," - ",i[2]," - ",i[3]
                            nombreprueba = ''.join(nombreprueba)
                            break
                    break
            identificacionatleta = input("Identificacion del atleta: ")
            while True:
                if len(identificacionatleta) > 20 or len(identificacionatleta) < 9:
                    print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                    identificacionatleta = input("Identificacion del atleta: ")
                else:
                    break
            while True:
                if esta(identificacionatleta,listaatletas) == True:
                    for i in listaatletas:
                        if identificacionatleta in i:
                            nombreatleta = i[1]," ",i[2]," ",i[3]
                            nombreatleta = ''.join(nombreatleta)
                            break
                    break
            si = False
            for i in listamarcas:  
                    for j in i[1:]:
                        for a in j[1:]:
                            if identificacion in i and codigo in j and identificacionatleta in a:
                                dorsal = a[1]
                                marca = a[2]
                                si = False
                                var = True
                                print("Dorsal del atleta: ",dorsal)
                                print("Marca del atleta: ",marca)
                                opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                                while True:
                                    if opcion == "A" or opcion == "C":
                                            break
                                    else:
                                        print("Digite una opcion valida")
                                        opcion = input("OPCIÓN <C> CANCELAR <A> ACEPTAR: ")
                                if opcion == "A":
                                    listamarcas[listamarcas.index(i)] = list(i)
                                    i = list(i)
                                    del listamarcas[listamarcas.index(i)]
                            else:
                                pass
            if si == False:
                print("MARCA NO ESTÁ REGISTRADA, NO SE PUEDE ELIMINAR")
                
#Funcion que imprime pdf de marcas por evento
# ENTRADAS: lista de marcas, lista de eventos, lista de atletas, lista de pruebas
# SALIDAS: pdf de marcas por evento  
def marcas_evento(listamarcas):
    nombres = []
    nombrespruebas = []
    codigos = []
    dorsales = []
    eventosvalidos = []
    marcas = []
    nombreseventos = []
    c = 1
    f = 0
    w = 0
    r = 0
    p = 0
    especificofechas = input("OPCION <E> Ver marcas de evento especifico <F> ver marcas de los eventos en un rango de fechas: ")
    if especificofechas == "E":
        identificacion = input("Identificacion del evento: ")
        while True:
                if isinstance(int(identificacion), int) == False or int(identificacion) < 1:
                    print("ERROR: La identificacion tiene que ser un numero entero mayor o igual a 1")
                    identificacion = input("Identificacion del evento: ")
                    if identificacion == "C":
                        return
                else:
                    break
        while True:
            if esta(identificacion,eventos) == True:
                for i in eventos:
                    if identificacion in i:
                        nombreevento = i[1]
                        break
                break
        for i in listamarcas: 
            if identificacion in i: 
                marca = i
                for j in i[1:]:
                    for a in j[1:]:
                        for l in atletas:
                            if a[0] in l:
                                dorsales.append(a[1])
                                nombreatleta = l[1]," ",l[2]," ",l[3]
                                nombreatleta = ''.join(nombreatleta)
                                nombres.append(nombreatleta)
                        for k in pruebas:
                            if j[0] in k:
                                codigos.append(j[0])
                                nombreprueba = k[1]," ",k[2]," ",k[3]
                                nombreprueba = ''.join(nombreprueba)
                                nombrespruebas.append(nombreprueba)
        marcas = ordenar(marca)
       
        with open("marcas.html", "w") as file:
            file.write("<b>APLICACION EVENTOS DE ATLETISMO</b><br>")
            file.write("<b>MARCAS POR EVENTO</b><br>")
            file.write("<br>")
            while r <= (len(marcas)-1):
                file.write("<b>Evento:&nbsp;</b>"+str(identificacion)+"&emsp;&emsp;"+str(nombreevento)+"<br>")
                file.write("<b>Prueba:&nbsp;</b>"+str(codigos[f])+"&emsp;&emsp;"+str(nombrespruebas[f])+"<br>")
                file.write("<b>Nombre atleta &emsp;&emsp;&emsp;&emsp; Dorsal &emsp;&emsp;&emsp;&emsp; Marca &emsp;&emsp;&emsp;&emsp; Lugar</b><br>")
                w = 0
                c = 1
                h = 0
                while w < len(marcas[0]):
                    file.write(str(nombres[f])+"&emsp;&emsp;&emsp;&emsp;&emsp;"+str(dorsales[f])+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+str(marcas[r][h])+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+str(c)+"<br>")
                    f += 1
                    c += 1
                    w += 1
                    h += 1
                r += 1
                    
        exe = "C:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe"
        config = pdfkit.configuration(wkhtmltopdf=exe)
        pdfkit.from_file("marcas.html", "marcas.pdf",configuration=config)
        webbrowser.open_new("marcas.pdf")
    if especificofechas == "F":
        fechainicial = input("Fecha inicial: ")
        while True:
            if len(fechainicial) != 8:
                print("ERROR: La fecha tiene que tener 8 caracteres")
                fechainicial = input("Fecha inicial del evento (ddmmaaaa): ")
            else:
                break
        fechafinal = input("Fecha final: ")
        while True:
            if len(fechafinal) != 8:
                print("ERROR: La fecha tiene que tener 8 caracteres")
                fechafinal = input("Fecha final del evento (ddmmaaaa): ")
            else:
                break
        while True:
            if fechainicial > fechafinal:
                print("ERROR: La fecha inicial no puede ser mayor que la fecha final")
                fechainicial = input("Fecha inicial: ")
                while True:
                    if len(fechainicial) != 8:
                        print("ERROR: La fecha tiene que tener 8 caracteres")
                        fechainicial = input("Fecha inicial del evento (ddmmaaaa): ")
                    else:
                        break
                fechafinal = input("Fecha final: ")
                while True:
                    if len(fechafinal) != 8:
                        print("ERROR: La fecha tiene que tener 8 caracteres")
                        fechafinal = input("Fecha final del evento (ddmmaaaa): ")
                    else:
                        break
            else:
                break
        for i in eventos:
            if fechainicial >= i[4] and i[5] >= fechafinal:
                eventosvalidos.append(i[0])
                nombreseventos.append(i[1])
        for i in listamarcas:
            for d in eventosvalidos:
                if d in i:
                    marcas.append(i)
                    for j in i[1:]:
                        for a in j[1:]:
                            for l in atletas:
                                if a[0] in l:
                                    dorsales.append(a[1])
                                    nombreatleta = l[1]," ",l[2]," ",l[3]
                                    nombreatleta = ''.join(nombreatleta)
                                    nombres.append(nombreatleta)
                            for k in pruebas:
                                if j[0] in k:
                                    codigos.append(j[0])
                                    nombreprueba = k[1]," ",k[2]," ",k[3]
                                    nombreprueba = ''.join(nombreprueba)
                                    nombrespruebas.append(nombreprueba)
        for marca in marcas:
            marcas1 = ordenar(marca)
            if marcas1 != None:
                listamarcas.append(marcas1)
        with open("marcas.html", "w") as file:
            file.write("<b>APLICACION EVENTOS DE ATLETISMO</b><br>")
            file.write("<b>MARCAS POR EVENTO</b><br>")
            while p <= (len(eventosvalidos)-1):
                if  f >= len(nombres):
                            break
                file.write("<br>")
                file.write("<b>Evento:&nbsp;</b>"+str(eventosvalidos[p])+"&emsp;&emsp;"+str(nombreseventos[p])+"<br>")
                r = 0
                while r <= (len(listamarcas[0])-1):
                    if  f >= len(nombres):
                            break
                    file.write("<b>Prueba:&nbsp;</b>"+str(codigos[f])+"&emsp;&emsp;"+str(nombrespruebas[f])+"<br>")
                    file.write("<b>Nombre atleta &emsp;&emsp;&emsp;&emsp; Dorsal &emsp;&emsp;&emsp;&emsp; Marca &emsp;&emsp;&emsp;&emsp; Lugar</b><br>")
                    w = 0
                    c = 1
                    h = 0
                    while w < len(listamarcas[0][0]):
                        if  f >= len(nombres):
                            break
                        file.write(str(nombres[f])+"&emsp;&emsp;&emsp;&emsp;&emsp;"+str(dorsales[f])+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+str(listamarcas[p][r][h])+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+str(c)+"<br>")
                        f += 1
                        c += 1
                        w += 1
                        h += 1
                    r += 1
                p += 1
        exe = "C:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe"
        config = pdfkit.configuration(wkhtmltopdf=exe)
        pdfkit.from_file("marcas.html", "marcas.pdf",configuration=config)
        webbrowser.open_new("marcas.pdf")

#Funcion que da las marcas por atleta en un pdf
#ENTRADAS: lista de marcas, lista de eventos, lista de atletas, lista de pruebas
#SALIDAS: pdf con las marcas por atleta
def marcas_atleta(listamarcas):
    nombrespruebas = []
    codigos = []
    nombreseventos = []
    c = 1
    f = 0
    w = 0
    r = 0
    p = 0
    especificotodos = input("OPCION <E> Ver marcas de atleta especifico <T> ver marcas todos los atletas: ")
    if especificotodos == "E":
        identificacion = input("Identificacion del atleta: ")
        while True:
            if len(identificacion) > 20 or len(identificacion) < 9:
                print("ERROR: La identificacion tiene que tener entre 9 y 20 caracteres")
                identificacion = input("Identificacion del atleta: ")
            else:
                break
        while True:
            for i in atletas:
                if identificacion in i:
                    nombreatleta = i[1]," ",i[2]," ",i[3]
                    break
            break
        
        for i in listamarcas: 
                for j in i[1:]:
                    for a in j[1:]:
                        if identificacion in a:
                            marca = i
                            for k in pruebas:
                                if j[0] in k:
                                    codigos.append(j[0])
                                    nombreprueba = k[1]," ",k[2]," ",k[3]
                                    nombreprueba = ''.join(nombreprueba)
                                    nombrespruebas.append(nombreprueba)
        marcas = ordenar(marca)
        for j in marcas:
            for i in eventos:
                nombreseventos.append(i[1])
       
       
        with open("marcas.html", "w") as file:
            file.write("<b>APLICACION EVENTOS DE ATLETISMO</b><br>")
            file.write("<b>MARCAS POR ATLETA</b><br>")
            file.write("<br>")
            while r <= (len(marcas)-1):
                file.write("<b>Atleta:&nbsp;</b>"+str(nombreatleta)+"<br>")
                file.write("<b>Prueba:&nbsp;</b>"+str(codigos[f])+"&emsp;&emsp;"+str(nombrespruebas[f])+"<br>")
                file.write("<b>Nombre evento &emsp;&emsp;&emsp;&emsp; Marca &emsp;&emsp;&emsp;&emsp; Posicion en el evento</b><br>")
                w = 0
                c = 1
                h = 0
                while w < len(marcas[0]):
                    file.write(str(nombreseventos[f])+"&emsp;&emsp;&emsp;&emsp;&emsp;"+str(marcas[r][h])+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+str(c)+"<br>")
                    f += 1
                    c += 1
                    w += 1
                    h += 1
                r += 1
                    
        exe = "C:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe"
        config = pdfkit.configuration(wkhtmltopdf=exe)
        pdfkit.from_file("marcas.html", "marcas.pdf",configuration=config)
        webbrowser.open_new("marcas.pdf")



#Menu principal
opcion = 1
while opcion != 0:
        if opcion == 1 or opcion == 2 or opcion == 3 or opcion == 4 or opcion == 5 or opcion == 6 or opcion == 7 or opcion == 8 or opcion == 0:
            print("EVENTOS DE ATLETISMO")  
            print("1. Registrar disciplinas")  
            print("2. Registrar pruebas por disciplina")  
            print("3. Registrar atletas")  
            print("4. Registrar eventos")  
            print("5. Registrar marcas")  
            print("6. Análisis de datos")  
            print("7. Ayuda")  
            print("8. Acerca de")  
            print("0. Salir")  
            opcion = int(input("Digite una opcion: "))
            clear()
            match opcion:
                case 1: #Registro de disciplinas
                    opcionregistrar = 1
                    while opcionregistrar != 0:
                        if opcionregistrar == 1 or opcionregistrar == 2 or opcionregistrar == 3 or opcionregistrar == 4 or opcionregistrar == 0:
                            print("")
                            print("EVENTOS DE ATLETISMO")  
                            print("")
                            print("REGISTRAR DISCIPLINAS")  
                            print("1. Agregar disciplinas")  
                            print("2. Consultar disciplinas")  
                            print("3. Modificar disciplinas") 
                            print("4. Eliminar disciplinas")  
                            print("0. Salir")  
                            opcionregistrar = int(input("Digite una opcion: "))
                            clear()
                            match opcionregistrar:
                                case 1:
                                    agregar_disciplinas(disciplinas)
                                case 2:
                                    consultar_disciplinas(disciplinas)
                                case 3:
                                    modificar_disciplinas(disciplinas)
                                case 4:
                                    eliminar_disciplinas(disciplinas)
                                case 0:
                                    pass
                            clear()
                        else:
                            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
                            opcionregistrar = 1
                case 2:
                    opcionpruebas = 1
                    while opcionpruebas != 0:
                        if opcionpruebas == 1 or opcionpruebas == 2 or opcionpruebas == 3 or opcionpruebas == 4 or opcionpruebas == 0:
                            print("")
                            print("EVENTOS DE ATLETISMO")  
                            print("")
                            print("REGISTRAR PRUEBAS POR DISCIPLINA")  
                            print("1. Agregar pruebas")  
                            print("2. Consultar pruebas")  
                            print("3. Modificar pruebas") 
                            print("4. Eliminar pruebas")  
                            print("0. Salir")  
                            opcionpruebas = int(input("Digite una opcion: "))
                            clear()
                            match opcionpruebas:
                                case 1:
                                    agregar_pruebas(pruebas,categorias,disciplinas)
                                case 2:
                                    consultar_pruebas(pruebas)
                                case 3:
                                    modificar_pruebas(pruebas)
                                case 4:
                                    eliminar_pruebas(pruebas)
                                case 0:
                                    pass
                            clear()
                        else:
                            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
                            opcionpruebas = 1
                case 3:
                    opcionatletas = 1
                    while opcionatletas != 0:
                        if opcionatletas == 1 or opcionatletas == 2 or opcionatletas == 3 or opcionatletas == 4 or opcionatletas == 0:
                            print("")
                            print("EVENTOS DE ATLETISMO")
                            print("")
                            print("REGISTRAR ATLETAS")
                            print("1. Agregar atletas")
                            print("2. Consultar atletas")
                            print("3. Modificar atletas")
                            print("4. Eliminar atletas")
                            print("0. Salir")
                            opcionatletas = int(input("Digite una opcion: "))
                            clear()
                            match opcionatletas:
                                case 1:
                                    agregar_atletas(atletas)
                                case 2:
                                    consultar_atletas(atletas)
                                case 3:
                                    modificar_atletas(atletas)
                                case 4:
                                    eliminar_atletas(atletas)
                                case 0:
                                    pass
                            clear()
                        else:
                            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
                            opcionatletas = 1
                case 4:
                    opcioneventos = 1
                    while opcioneventos != 0:
                        if opcioneventos == 1 or opcioneventos == 2 or opcioneventos == 3 or opcioneventos == 4 or opcioneventos == 0:
                            print("")
                            print("EVENTOS DE ATLETISMO")
                            print("")
                            print("REGISTRAR EVENTOS")
                            print("1. Agregar eventos")
                            print("2. Consultar eventos")
                            print("3. Modificar eventos")
                            print("4. Eliminar eventos")
                            print("0. Salir")
                            opcioneventos = int(input("Digite una opcion: "))
                            clear()
                            match opcioneventos:
                                case 1:
                                    agregar_eventos(eventos)
                                case 2:
                                    consultar_eventos(eventos)
                                case 3:
                                    modificar_eventos(eventos)
                                case 4:
                                    eliminar_eventos(eventos)
                                case 0:
                                    pass
                            clear()
                        else:
                            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
                            opcioneventos = 1
                case 5:
                    opcionmarcas = 1
                    while opcionmarcas != 0:
                        if opcionmarcas == 1 or opcionmarcas == 2 or opcionmarcas == 3 or opcionmarcas == 4 or opcionmarcas == 0:
                            print("")
                            print("EVENTOS DE ATLETISMO")
                            print("")
                            print("REGISTRAR MARCAS POR EVENTO")
                            print("1. Agregar marcas")
                            print("2. Consultar marcas")
                            print("3. Modificar marcas")
                            print("4. Eliminar marcas")
                            print("0. Salir")
                            opcionmarcas = int(input("Digite una opcion: "))
                            clear()
                            match opcionmarcas:
                                case 1:
                                    agregar_marcas(eventos,pruebas,atletas,marcas_por_evento,disciplinas)
                                case 2:
                                    consultar_marcas(eventos,pruebas,atletas,marcas_por_evento)
                                case 3:
                                    modificar_marcas(eventos,pruebas,atletas,marcas_por_evento)
                                case 4:
                                    eliminar_marcas(eventos,pruebas,atletas,marcas_por_evento)
                                case 0:
                                    pass
                            clear()
                        else:
                            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
                            opcionmarcas = 1
                case 6:
                    opcionanalisis = 1
                    while opcionanalisis != 0:
                        if opcionanalisis == 1 or opcionanalisis == 2 or opcionanalisis == 3 or opcionanalisis == 0:
                            print("")
                            print("EVENTOS DE ATLETISMO")
                            print("")
                            print("ANALISIS DE DATOS")
                            print("1. Marcas por evento")
                            print("2. Marcas por atleta")
                            print("3. Mejores marcas por prueba")
                            print("0. Salir")
                            opcionanalisis = int(input("Digite una opcion: "))
                            clear()
                            match opcionanalisis:
                                case 1:
                                    marcas_evento(marcas_por_evento)
                                case 2:
                                    marcas_atleta(marcas_por_evento)
                                case 3:
                                    print("No sue como hacerlo por fecha")
                                case 0:
                                    pass
                            clear()
                        else:
                            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
                            opcionanalisis = 1
                case 7:
                    webbrowser.open_new('manual_de_usuario_eventos_de_atletismo.pdf')
                case 8:
                    print(8)
                case 0:
                    pass
            clear()
        else:
            print("ERROR: la opcion debe estar dentro de las opcoines del menu")
            opcion = 1
