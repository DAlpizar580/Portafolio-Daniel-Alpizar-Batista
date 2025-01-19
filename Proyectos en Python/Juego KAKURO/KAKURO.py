from tkinter import ttk
from tkinter import *
from tkinter import StringVar
from tkinter import messagebox
import tkinter as tk
import pickle
import random
import webbrowser

#-------------------Menu----------------------
menu = tk.Tk()
menu.title("Proyecto 2 Taller de programacion Daniel Alpizar Batista")
menu.geometry("600x625")

#Titulo del menu
titulo = tk.Label(menu, text='KAKURO', font = "Arial 40 bold")
titulo.pack()

#--------------------Variables para Jugar----------------------
archivoconfig = open("kakuro2023configuración.dat","rb")
config = pickle.load(archivoconfig)
dif = "FACIL"
clc = "Cronometro"
numero = "0"
reloj = config[1]
numtablero = ""
Dificultad = config[0]
lista_numeros = []
terminar = False
iniciado = False
borrar_casi = False
matrizfilas = []
matrizcolumnas = []
pmatrizfilas = []
pmatrizcolumnas = []
todoslosbotones = []
h = 0
m = 0
s = 0
nombre1 = StringVar()
tiempo_jugadores = []
lista_jugadas = []
lista_rehacer = []
partida = []
negrastxt = []
botonescreados = []
idbotones = []
ptotalfilas = []
ptotalcolumnas = []
totalfilas = []
totalcolumnas = []
detener = False
Tablero = ""
solve = ""
Creacion = False

#---------------------------Utilizar partida random------------------------
#Abre archivo con partidas
archivopartidas = open("kakuro2023partidas.dat","rb")
partidas = pickle.load(archivopartidas)
numeros_disponibles = [0, 1, 2]
#Numero de tablero aleatorio
def num_aleatorio():
    global numeros_disponibles
    if numeros_disponibles == []:
        numeros_disponibles = [0, 1, 2]
    numero_aleatorio = random.sample(numeros_disponibles, 1)[0]
    numeros_disponibles.remove(numero_aleatorio)
    return numero_aleatorio







#Funcion Jugar
def Jugar():
    global matrizfilas,nombre1,matrizcolumnas,partidas,partida,pmatrizfilas,pmatrizcolumnas,todoslosbotones,Dificultad,numeros_disponibles, numtablero, negrastxt, botonescreados, idbotones, ptotalfilas, ptotalcolumnas, totalfilas, totalcolumnas
    #Escoge un tablero aleatorio
    def escoger_tablero():
        global numtablero, partida, Dificultad
        numtablero = num_aleatorio()
        partida = partidas[Dificultad][numtablero]
    escoger_tablero()
    #Abrir ventana para Jugar
    jugar = tk.Tk()
    jugar.title("Proyecto 2 Taller de programacion Daniel Alpizar Batista")
    jugar.geometry("600x625")

    #-------------------Funciones para Jugar parte 1----------------------
    #Entrada: numero seleccionado y id del boton
    #Salida: Se guarda el numero en una variable y se pinta y despintan los numeros seleccionados
    def click_numeros(num,boton):
        global numero
        #Variable global con el numero
        numero = str(num)
        #Desseleccionar los botones
        for i in botones:
            i.config(bg = "white")
        #Seleccionar el boton
        boton.config(bg= "#1EC6CE")

    #Entrada:Nombre del ususario
    #Salida: Error si el nombre tiene menos de 1 caracter o mas de 40
    def validacion_nombre():
        global nombre1
        nombre1 = nombre.get()
        if 1 > len(nombre.get()) > 40:
            messagebox.showerror("Error", "El nombre debe ser menor a 40 caracteres")

    #Entrada: Boton borrar
    #Salida: Se eliminan todos los valores de las casillas
    def borrar_juego():
        global lista_jugadas
        if lista_jugadas != []:
            #Confirmacion para borrar
            answer = messagebox.askyesno("Ventana", "¿ESTÁ SEGURO DE BORRAR EL JUEGO (SI/NO)?")
            if answer:
                for sublista in matrizfilas:
                    for boton in sublista:
                        boton.config(text = "")
                lista_jugadas = []
            else:
                pass
        else:
            messagebox.showinfo("Error", "NO SE HAN REALIZADO JUGADAS")
                     
    #Entrada: Boton iniciar
    #Salida: inicia el coronometro cuando el juego inicia
    def iniciar_juego():
        global h, m, s, terminar, iniciado, detener,solve
        iniciado = True
        #Valida que haya un nombre puesto
        if nombre.get() == "":
            messagebox.showinfo("Error", "Se debe dar un nombre antes de iniciar el juego")
            return
        #Valida que no se haya detenido el cronometro
        if detener == False:
            b_iniciar_juego.config(state = "disabled")
            #Cronometro
            if reloj == "Cronometro":
                s += 1
                if s == 60:
                    m += 1
                    s = 0
                if m == 60:
                    h += 1
                    m = 0
                    s = 0
                    
                segundos.config(text= str(s))
                minutos.config(text = str(m))
                horas.config(text = str(h))
            #Repeticion del cronometro
            solve = jugar.after(1000, iniciar_juego)
            #Maximo de tiempo
            if h > 2:
                jugar.after_cancel(solve)
                messagebox.showinfo("Error", "Se ha llegado al limite de tiempo")
                return

    #Entrada: Boton de deshacer
    #Salida: Deshace la ultima jugada
    def deshacer_jugada():
        if not lista_jugadas:
            messagebox.showerror("Error", "No hay jugadas para deshacer")
            return
        #Ultima jugada
        ultimo = lista_jugadas.pop()
        #Borra ultima jugada
        matrizfilas[ultimo[0]][ultimo[1]].config(text = " ")
        #Apunta el numero a la lista de rehacer
        ultimo_numero = lista_numeros.pop()
        lista_rehacer.append([ultimo, ultimo_numero])
        
    #Entrada: Boton borrar casilla
    #Salida: Borra una casilla
    def borrar_casilla():
        global numero
        #Apunta una casilla vacia a la para borrarla
        for i in botones:
            i.config(bg = "white")
        numero = ""

    #Entrada: Boton rehacer
    #S: Se rehace la ultima jugada
    def rehacer_jugada():
        global lista_jugadas, lista_rehacer, lista_numeros
        
        #Verificar si hay jugadas que se puedan rehacer
        if not lista_rehacer:
            messagebox.showinfo("Información", "No hay jugadas para rehacer")
            return
        jugada_deshacer = lista_rehacer.pop() #Ultima jugada deshecha
        lugar = jugada_deshacer[0] #Posicion
        numero = jugada_deshacer[1] #Numero
        matrizfilas[lugar[0]][lugar[1]].config(text = numero) #Reponer numero
        lista_numeros.append(numero) #Agrega a lista de numeros
        lista_jugadas.append(lugar) #Agregar a lista de jugadas
    
    def terminar_juego():
        global iniciado, solve, Creacion, Tablero, detener, numtablero, Dificultad, lista_jugadas,lista_numeros, h, m, s,pmatrizfilas,pmatrizcolumnas,ptotalfilas,ptotalcolumnas,partida,negrastxt,botonescreados,idbotones,totalcolumnas,totalfilas,matrizcolumnas,matrizfilas,todoslosbotones, lista_rehacer
        #Verifica que se haya iniciado el juego
        if iniciado == False:
            messagebox.showinfo("Error",  "DEBE INICIAR JUEGO")
            return
        #Se asegura que se desee terminar el juego
        answer = messagebox.askyesno("Ventana", "¿ESTÁ SEGURO DE TERMINAR EL JUEGO (SI/NO)?")
        #Si se desea se procede a terminarlo
        if answer:
            #Detiene el juego
            iniciado = False
            detener = True
            #Escoge tablero nuevo
            escoger_tablero()
            #Reinicia variables
            matrizfilas = []
            lista_numeros = []
            matrizcolumnas = []
            pmatrizfilas = []
            pmatrizcolumnas = []
            todoslosbotones = []
            lista_jugadas = []
            lista_rehacer = []
            negrastxt = []
            botonescreados = []
            idbotones = []
            ptotalfilas = []
            ptotalcolumnas = []
            totalfilas = []
            totalcolumnas = []
            #Borra tablero actual
            for widget in Tablero.winfo_children():
                widget.destroy()
            Tablero.grid_forget()
            #Crea nuevo tablero
            crear_tablero()
            #Agrega funcion a los nuevos botones
            for i in todoslosbotones:
                i.config(command=lambda b=i: clic_en_boton(b))
            #Reinicia cronometro
            s = 0
            m = 0
            h = 0
            segundos.config(text= str(s))
            minutos.config(text = str(m))
            horas.config(text = str(h))
            #Activa boton de iniciar
            b_iniciar_juego.config(state = "normal")
            #Cancela repeticion de cronometro
            jugar.after_cancel(solve)
            detener = False
    

    #------------------Creacion de la interfaz grafica de Jugar----------------------
    #Título
    titulo = tk.Label(jugar, text='KAKURO', font = "Arial 25 bold")
    titulo.place(x = 10, y = 10)

    #Label para el nombre
    nombre_label = tk.Label(jugar, text='Jugador', font = "Helvetica 10")
    nombre_label.place(x = 310, y = 20)

    #Label para la dificultad
    dificultad_label = tk.Label(jugar, text=Dificultad, font = "Helvetica 15")
    dificultad_label.place(x = 230, y = 580)

    #Caja de texto para el nombre
    nombre1 = StringVar()
    nombre = tk.Entry(jugar, textvariable = nombre1)
    nombre.place(x = 360, y = 20)

    #Boton para validar el nombre y añadirlo a la lista de jugadores
    boton_nombre = tk.Button(jugar, text="Aceptar", width=5, height=1, command = validacion_nombre)
    boton_nombre.place(x = 490, y = 15)

    #--------------------Creacion de tablero y listas relacionadas con el----------------------------------------------
    def crear_tablero():
        global pmatrizfilas,pmatrizcolumnas,ptotalfilas,ptotalcolumnas,partida,negrastxt,botonescreados,idbotones,totalcolumnas,totalfilas,matrizcolumnas,matrizfilas,todoslosbotones,Tablero
        #Crear frame para el tablero
        Tablero = tk.Frame(jugar, borderwidth=1, relief="solid")
        Tablero.place(x=230, y=250, anchor="center")
        #crear casillas sin nada en el tablero
        for columna in range(9):
            for fila in range(9):
                negras = tk.Canvas(Tablero, width=40, height=40, bg="black")
                negras.grid(row=fila, column=columna)
        #Crea matrizes para filas y columnas con la posicion de los botones y crea el total de columnas con la posicion de los botones
        for i in partida:
            psublistafilas = []
            psublistacolumnas = []
            subtotalfilas = []
            subtotalcolumnas = []
            for k in range(1, int(i[4])+1):
                if i[0] == "1":
                    psublistafilas.append((int(i[2]),int(i[3])+k))
                    subtotalfilas.append((int(i[2]),int(i[3])+k))
                elif i[0] == "2":
                    psublistacolumnas.append((int(i[2])+k,int(i[3])))
                    subtotalcolumnas.append((int(i[2])+k,int(i[3])))
            if i[0] == "1":
                pmatrizfilas.append(psublistafilas)
                ptotalfilas.append((subtotalfilas,i[1]))
            if i[0] == "2":
                pmatrizcolumnas.append(psublistacolumnas)
                ptotalcolumnas.append((subtotalcolumnas,i[1]))
        #Escribe en las casillas las claves numericas y crea los botones
        for i in partida:
            if (i[2],i[3]) not in negrastxt: #Valida que no se repita
                #Crea casilla para ponerle las claves numericas
                casilla = tk.Canvas(Tablero, width=40, height=40, bg="black")
                casilla.grid(row=i[2],column=i[3])
                #Crea los botones del tablero y un id para los botones
                for k in range(1, int(i[4])+1):
                    if i[0] == "1":
                        if (int(i[2]),int(i[3])+k) not in botonescreados:
                            botones = tk.Button(Tablero, width = 5, height=2, bg="white", text="")
                            botones.grid(row=int(i[2]), column=int(i[3])+k)
                            botonescreados.append((int(i[2]),int(i[3])+k))
                            idbotones.append([(int(i[2]),int(i[3])+k),botones])
                    elif i[0] == "2":
                        if (int(i[2])+k,int(i[3])) not in botonescreados:
                            botones = tk.Button(Tablero, width = 5, height=2, bg="white", text="")
                            botones.grid(row=int(i[2])+k, column=int(i[3])) 
                            botonescreados.append((int(i[2])+k,int(i[3])))
                            idbotones.append([(int(i[2])+k,int(i[3])),botones])
                negrastxt.append((i[2],i[3]))
                #Crea linea de separacion en la casilla de las claves numericas
                casilla.create_line(0, 0, 66, 66, width=2, fill="white")
                #Crea texto para las casillas
                for b in partida:
                    if (b[2],b[3]) == (i[2],i[3]):
                        if b[0] == "1":
                            casilla.create_text(27, 12, text=b[1],fill="white",font=('Helvetica 10 bold'))
                        elif b[0] == "2":
                            casilla.create_text(12, 27, text=b[1],fill="white",font=('Helvetica 10 bold'))
        #Crea la variable de total columnas con las posiciones en la matriz de columnas
        for j in ptotalcolumnas:
            sublista = []
            for a in j[0]:
                for i in pmatrizcolumnas:
                    for k in i:
                        if a == k:
                            sublista.append((pmatrizcolumnas.index(i),i.index(k)))
            totalcolumnas.append((sublista,j[1]))
        #Crea la variable de total filas con las posiciones en la matriz de filas
        for j in ptotalfilas:
            sublista = []
            for a in j[0]:
                for i in pmatrizfilas:
                    for k in i:
                        if a == k:
                            sublista.append((pmatrizfilas.index(i),i.index(k)))
            totalfilas.append((sublista,j[1]))
        #Crea la matriz de columnas con los botones
        for j in pmatrizcolumnas:
            sublistacolumnas = []
            for a in j:
                for i in idbotones:
                    if a in i:
                        sublistacolumnas.append(i[1])
            if sublistacolumnas != []:
                matrizcolumnas.append(sublistacolumnas)
        #Crea la matriz de filas con los botones
        for j in pmatrizfilas:
            sublistafilas = []
            for a in j:
                for i in idbotones:
                    if a in i:
                        sublistafilas.append(i[1])
            if sublistafilas != []:
                matrizfilas.append(sublistafilas)
        #Crea lista con todos los botones
        for i in idbotones:
            todoslosbotones.append(i[1])
    #Crea tablero
    crear_tablero()

    # Crear botones de numeros y colocarlos en el Frame de los botones
    boton1 = tk.Button(jugar, text="1", width=5, height=2, command=lambda: click_numeros(1,boton1))
    boton1.place(x = 480, y = 80)

    boton2 = tk.Button(jugar, text="2", width=5, height=2, command=lambda: click_numeros(2,boton2))
    boton2.place(x = 480, y = 120)

    boton3 = tk.Button(jugar, text="3", width=5, height=2, command=lambda: click_numeros(3,boton3))
    boton3.place(x = 480, y = 160)

    boton4 = tk.Button(jugar, text="4", width=5, height=2, command=lambda: click_numeros(4,boton4))
    boton4.place(x = 480, y = 200)

    boton5 = tk.Button(jugar, text="5", width=5, height=2, command=lambda: click_numeros(5,boton5))
    boton5.place(x = 480, y = 240)

    boton6 = tk.Button(jugar, text="6", width=5, height=2, command=lambda: click_numeros(6,boton6))
    boton6.place(x = 480, y = 280)

    boton7 = tk.Button(jugar, text="7", width=5, height=2, command=lambda: click_numeros(7,boton7))
    boton7.place(x = 480, y = 320)

    boton8 = tk.Button(jugar, text="8", width=5, height=2, command=lambda: click_numeros(8,boton8))
    boton8.place(x = 480, y = 360)

    boton9 = tk.Button(jugar, text="9", width=5, height=2, command=lambda: click_numeros(9,boton9))
    boton9.place(x = 480, y = 400)


    #Lista de los botones
    botones = [boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9]

    #Botones de funcionalidad del juego
    b_iniciar_juego = tk.Button(jugar, text="INICIAR JUEGO", width=10, height=2, bg = "pink", command = iniciar_juego)
    b_iniciar_juego.place(x = 45, y = 470)

    b_deshacer = tk.Button(jugar, text="DESHACER \n JUGADA", width=10, height=2, bg="#90EE90", command = deshacer_jugada)
    b_deshacer.place(x = 235, y = 470)

    b_rehacer = tk.Button(jugar, text="REHACER \n JUGADA", width=10, height=2, bg="#00CCFF", command = rehacer_jugada)
    b_rehacer.place(x = 235, y = 520)

    b_borrar_casilla = tk.Button(jugar, text="BORRAR \n CASILLA", width=10, height=2, bg="gray", command = borrar_casilla)
    b_borrar_casilla.place(x = 325, y = 470)

    b_borrar_juego = tk.Button(jugar, text="BORRAR \n JUEGO", width=10, height=2, bg="#0066FF", command = borrar_juego)
    b_borrar_juego.place(x = 325, y = 520)

    b_terminar_juego = tk.Button(jugar, text="TERMINAR \n JUEGO", width=10, height=2, bg="#009933", command= terminar_juego)
    b_terminar_juego.place(x = 325, y = 570)

    b_top_10 = tk.Button(jugar, text="TOP \n 10", width=10, height=2, bg="yellow")
    b_top_10.place(x = 415, y = 470)

    b_guardar_juego = tk.Button(jugar, text="GUARDAR \n JUEGO", width=10, height=2, bg="orange")
    b_guardar_juego.place(x = 415, y = 520)

    b_cargar_juego = tk.Button(jugar, text="CARGAR \n JUEGO", width=10, height=2, bg="#CC3300")
    b_cargar_juego.place(x = 415, y = 570)

    #Valida que haya reloj
    if reloj != "Sin reloj":
        #Cronometro
        # Crear el primer grupo de labels
        label_group_top = tk.Frame(jugar, width=250, height=50, bd=2, relief="groove")
        label_group_top.place(x=30, y=520)

        titulo_horas = tk.Label(label_group_top, text="Horas", width=8, height=1, relief="ridge", borderwidth=2)
        titulo_horas.pack(side=tk.LEFT)

        titulo_minutos = tk.Label(label_group_top, text="Minutos", width=8, height=1, relief="ridge", borderwidth=2)
        titulo_minutos.pack(side=tk.LEFT)

        titulo_segundos = tk.Label(label_group_top, text="Segundos", width=8, height=1, relief="ridge", borderwidth=2)
        titulo_segundos.pack(side=tk.LEFT)

        # Crear el segundo grupo de labels
        label_group_bottom = tk.Frame(jugar, width=250, height=50, bd=2, relief="groove")
        label_group_bottom.place(x=30, y=540)

        horas = tk.Label(label_group_bottom, text= str(h), width=8, height=4, relief="ridge", borderwidth=2)
        horas.pack(side=tk.LEFT)

        minutos = tk.Label(label_group_bottom, text= str(m), width=8, height=4, relief="ridge", borderwidth=2)
        minutos.pack(side=tk.LEFT)

        segundos = tk.Label(label_group_bottom, text= str(s), width=8, height=4, relief="ridge", borderwidth=2)
        segundos.pack(side=tk.LEFT)

        

    

    #Entrada: un boton
    #Salida: La posicion del boton dentro de la matriz
    def obtener_posicion(boton,foc):
        global matrizfilas,matrizcolumnas
        if foc == "f":
            for i in matrizfilas:
                if boton in i:
                    return ((matrizfilas.index(i),i.index(boton)))
        elif foc == "c":
            for i in matrizcolumnas:
                if boton in i:
                    return ((matrizcolumnas.index(i),i.index(boton)))

    #Entrada: Boton donde se quiere poner el numero
    #Salida: Valida que sea posible poner el boton y si lo es pone el numero sino da el error correspondiente
    def clic_en_boton(boton):
        #Declaracion de variables
        global borrar_casi, matrizfilas,matrizfilas, lista_numeros, iniciado
        matrizcolumnas_txt = []
        matrizfilas_txt = []
        #Validar que el juego este iniciado
        if iniciado == False:
            messagebox.showinfo("Error",  "DEBE INICIAR JUEGO")
            return
        #Validar que se haya seleccionado un numero
        if numero == "0":
            messagebox.showinfo("Error",  "DEBE SELECCIONAR UN NÚMERO")
            return
        #Posiciones en la lista de filas y columnas
        posicionfilas = obtener_posicion(boton,"f")
        posicioncolumnas = obtener_posicion(boton,"c")
        #Crea la matrizcolumnas pero con los valores de texto
        for sublista in matrizcolumnas:
            sublista_txt = []
            for j in sublista:
                texto = j.cget("text")
                sublista_txt.append(texto)
            if len(sublista_txt) >= 2:
                matrizcolumnas_txt.append(sublista_txt)
        #Crea la matrizfilas pero con los valores de texto
        for sublista in matrizfilas:
            sublista_txt = []
            for j in sublista:
                texto = j.cget("text")
                sublista_txt.append(texto)
            if len(sublista_txt) >= 2:
                matrizfilas_txt.append(sublista_txt)
        #Valida que el numero no este repetido en la fila
        if numero != "":
            for i in matrizfilas_txt:
                if numero in i and matrizfilas_txt.index(i) == posicionfilas[0]:
                    messagebox.showinfo("Error",  "JUGADA NO ES VÁLIDA PORQUE EL NÚMERO YA ESTÁ EN SU GRUPO DE FILA")
                    return
        #Valida que el numero no este repetido en la columna
        if numero != "":
            for i in matrizcolumnas_txt:
                if numero in i and matrizcolumnas_txt.index(i) == posicioncolumnas[0]:
                    messagebox.showinfo("Error",  "JUGADA NO ES VÁLIDA PORQUE EL NÚMERO YA ESTÁ EN SU GRUPO DE COLUMNA")
                    return
        #Sacar el largo de la fila donde se encuentra el boton y una lista con los numeros enteros en ella
        fila_int = []
        for i in matrizfilas_txt:
            if matrizfilas_txt.index(i) == posicionfilas[0]:
                largofila = len(i)
                for a in i:
                    if a != "":
                        fila_int.append(int(a))
        #Sacar el largo de la columna donde se encuentra el boton
        columna_int = []
        for i in matrizcolumnas_txt:
            if matrizcolumnas_txt.index(i) == posicioncolumnas[0]:
                largocolumna = len(i)
                for a in i:
                    if a != "":
                        columna_int.append(int(a))
        #Valida que la suma de las filas no sea mayor a lo permitido
        if numero != "": #Valida que la opcion borrar casilla no este activada
            sumafila = sum(fila_int)+int(numero)
            for a in totalfilas:
                if posicionfilas in a[0]:
                    if int(a[1]) < sumafila:
                        messagebox.showinfo("Error",  "JUGADA NO ES VÁLIDA PORQUE LA SUMA DE LA FILA ES " + str(sumafila) + " Y LA CLAVE NUMÉRICA ES " + a[1])
                        return
        #Valida que la suma de las columnas no sea mayor a lo permitido
        if numero != "": #Valida que la opcion borrar casilla no este activada
            sumacolumna = sum(columna_int)+int(numero)
            for a in totalcolumnas:
                if posicioncolumnas in a[0]:
                    if int(a[1]) < sumacolumna:
                        messagebox.showinfo("Error",  "JUGADA NO ES VÁLIDA PORQUE LA SUMA DE LA COLUMNA ES " + str(sumacolumna) + " Y LA CLAVE NUMÉRICA ES " + a[1])
                        return
        if numero != "":
            #Guarda la jugada en una lista
            lista_jugadas.append(posicionfilas)
            #Se agrega el numero a los numeros jugados
            lista_numeros.append(numero)
        #Escribe el numero en el boton
        matrizfilas[posicionfilas[0]][posicionfilas[1]].config(text = numero)
        for i in matrizfilas_txt:
            for a in i:
                if a == "":
                    return
        #Final si ya se llenaron todas las casillas
        final()
        return

    # Asociar la función `clic_en_boton` a todos los botones
    for i in todoslosbotones:
        i.config(command=lambda b=i: clic_en_boton(b))

    #Entrada: boton guardar juego
    #Salida: guarda los datos del juego en un .dat
    def guardar_juego():
        global iniciado, partida, matrizfilas,detener,h,m,s
        #Validar que exista un juego
        if iniciado == False:
            return
        #Detiene cronometro
        detener = True
        #Variables que se van a guardar
        juegoactual = (partida,(h,m,s),lista_numeros,lista_jugadas)
        #Abre .dat y guarda las variables
        with open('kakuro2023juegoactual.dat', 'wb') as file:
            pickle.dump(juegoactual,file)
        #Varifica si se quiere continuar el juego o no
        answer = messagebox.askyesno("Ventana", "¿VA A CONTINUAR EL JUEGO (SI/NO)?")
        if answer:
            detener = False
        else:
            terminar_juego()
    #Agrega la funcion al boton
    b_guardar_juego.config(command=guardar_juego)
    #Entradas: boton cargar juego
    #Salidas: abre el juego guardado
    def cargar_juego():
        global iniciado, solve, Creacion, Tablero, detener, numtablero, Dificultad, lista_jugadas,lista_numeros, h, m, s,pmatrizfilas,pmatrizcolumnas,ptotalfilas,ptotalcolumnas,partida,negrastxt,botonescreados,idbotones,totalcolumnas,totalfilas,matrizcolumnas,matrizfilas,todoslosbotones, lista_rehacer
        #Abre .dat con el juego
        archivojuegoactual = open('kakuro2023juegoactual.dat', 'rb')
        #Saca los valores del .dat
        juegoactual = pickle.load(archivojuegoactual)
        partida = juegoactual[0]
        lista_numeros = juegoactual[2]
        lista_jugadas = juegoactual[3]
        h = juegoactual[1][0]
        m = juegoactual[1][1]
        s = juegoactual[1][2]
        #Actualiza cronometro
        segundos.config(text= str(s))
        minutos.config(text = str(m))
        horas.config(text = str(h))
        #Activa boton iniciar
        b_iniciar_juego.config(state = "normal")
        #Reinicia variables
        matrizfilas = []
        matrizcolumnas = []
        pmatrizfilas = []
        pmatrizcolumnas = []
        todoslosbotones = []
        lista_rehacer = []
        negrastxt = []
        botonescreados = []
        idbotones = []
        ptotalfilas = []
        ptotalcolumnas = []
        totalfilas = []
        totalcolumnas = []
        #Borra tablero actual
        for widget in Tablero.winfo_children():
            widget.destroy()
        Tablero.grid_forget()
        #Crea tablero nuevo
        crear_tablero()
        #Añade funcion a los botones
        for i in todoslosbotones:
            i.config(command=lambda b=i: clic_en_boton(b))
        #Añade los valores a los botones que tenian numero
        for i in range(len(lista_numeros)):
            ultimo = lista_jugadas.pop()
            ultimo_numero = lista_numeros.pop()
            matrizfilas[ultimo[0]][ultimo[1]].config(text = ultimo_numero)
    #Añade funcion al boton cargaar
    b_cargar_juego.config(command=cargar_juego)

    #Entradas: Todas las casillas llenas
    #Salidas: Fin del juego e inicia otro
    def final():
        global iniciado, solve, Creacion, Tablero, detener, numtablero, Dificultad, lista_jugadas,lista_numeros, h, m, s,pmatrizfilas,pmatrizcolumnas,ptotalfilas,ptotalcolumnas,partida,negrastxt,botonescreados,idbotones,totalcolumnas,totalfilas,matrizcolumnas,matrizfilas,todoslosbotones, lista_rehacer
        matrizfilas_txt = []
        #Valida que todos los botones tengan valor
        for sublista in matrizfilas:
            sublista_txt = []
            for j in sublista:
                texto = j.cget("text")
                sublista_txt.append(texto)
            if len(sublista_txt) >= 2:
                matrizfilas_txt.append(sublista_txt)
        for i in matrizfilas_txt:
            for a in i:
                if a == "":
                    return
        #Mensaje del fin
        messagebox.showinfo("Flicidades",  "¡EXCELENTE " + nombre1.get() +"! TERMINÓ EL JUEGO CON ÉXITO")
        #Detiene cronometro
        iniciado = False
        detener = True
        #Tiempo final
        tiempo = h*10**4+m*10**2+s
        tiempo_jugadores.append((tiempo,nombre1.get(),Dificultad))
        #Escoge nuevo tablero
        escoger_tablero()
        #Reinicia Variables
        matrizfilas = []
        matrizcolumnas = []
        pmatrizfilas = []
        pmatrizcolumnas = []
        todoslosbotones = []
        lista_jugadas = []
        lista_numeros = []
        lista_rehacer = []
        negrastxt = []
        botonescreados = []
        idbotones = []
        ptotalfilas = []
        ptotalcolumnas = []
        totalfilas = []
        totalcolumnas = []
        #Borra tablero terminado
        for widget in Tablero.winfo_children():
            widget.destroy()
        Tablero.grid_forget()
        #Crea nuevo tablero
        crear_tablero()
        #Añade funcion a los botones
        for i in todoslosbotones:
            i.config(command=lambda b=i: clic_en_boton(b))
        #Reinicia cronometro
        s = 0
        m = 0
        h = 0
        segundos.config(text= str(s))
        minutos.config(text = str(m))
        horas.config(text = str(h))
        #Activa boton iniciar
        b_iniciar_juego.config(state = "normal")
        jugar.after_cancel(solve)
        detener = False
    #Fin del loop jugar
    jugar.mainloop()


#-----------------------------------------Configuracion---------------------------------------------
def Configurar():
    global dif,clc
    #Crear ventana configurar
    configurar = tk.Tk()
    configurar.title("Proyecto 2 Taller de programacion Daniel Alpizar Batista")
    configurar.geometry("600x625")
    #------------------------------Nivel--------------------------------------------------
    def Facil():
        global dif
        dif = "FACIL"
    def Medio():
        global dif
        dif = "MEDIO"
    def Dificil():
        global dif
        dif = "DIFICIL"
    def Experto():
        global dif
        dif = "EXPERTO"
    #Botones para elejir dificultad
    nivel = tk.Label(configurar, text="Nivel:",font = "Arial 20", width=8, height=1)
    nivel.place(x=70, y=100)
    boton_facil = tk.Button(configurar, text="FACIL",font = "Arial 10", width=8, height=1, command = Facil)
    boton_facil.place(x=240, y=110)
    boton_medio = tk.Button(configurar, text="MEDIO",font = "Arial 10", width=8, height=1, command = Medio)
    boton_medio.place(x=240, y=140)
    boton_dificil = tk.Button(configurar, text="DIFICIL",font = "Arial 10", width=8, height=1, command = Dificil)
    boton_dificil.place(x=240, y=170)
    boton_experto = tk.Button(configurar, text="EXPERTO",font = "Arial 10", width=8, height=1, command = Experto)
    boton_experto.place(x=240, y=200)
    #---------------------------------Reloj------------------------------------------------------------------------------------
    def Cronometro():
        global clc
        clc = "Cronometro"
    def Sin_reloj():
        global clc
        clc = "Sin reloj"
    def Timer():
        global clc
        clc = "Timer"
    #Botones para elejir tipo de reloj
    Reloj = tk.Label(configurar, text="Reloj:",font = "Arial 20", width=8, height=1)
    Reloj.place(x=70, y=300)
    boton_Cronometro = tk.Button(configurar, text="Cronometro",font = "Arial 10", width=10, height=1, command = Cronometro)
    boton_Cronometro.place(x=240, y=310)
    boton_Sin_reloj = tk.Button(configurar, text="No usar reloj",font = "Arial 10", width=10, height=1, command = Sin_reloj)
    boton_Sin_reloj.place(x=240, y=340)
    boton_Timer = tk.Button(configurar, text="Timer",font = "Arial 10", width=10, height=1, command = Timer)
    boton_Timer.place(x=240, y=370)
    #Guarda informacion en .dat
    def save():
        with open('kakuro2023configuración.dat', 'wb') as file:
            pickle.dump((dif,clc),file)
    boton_save = tk.Button(configurar, text="Save",font = "Arial 15", width=10, height=1, command = save)
    boton_save.place(x=240, y=550)
    #Fin de configuracion
    configurar.mainloop()
    

def Ayuda():
    webbrowser.open_new(r'manual_de_usuario_kakuro.pdf')

#Datos acerca del programa
def Acerca_de():
    #Abre ventana
    acerca_de = tk.Tk()
    acerca_de.title("Proyecto 2 Taller de programacion Daniel Alpizar Batista")
    acerca_de.geometry("600x625")
    #Datos del programa
    txt = "Juego kakuro \n Proyecto 2 Taller de programacion \n Autor: Daniel ALpizar Batista \n Version 1 \n Fecha de creacion: 27/05/2023"
    #Label con los datos
    acercade = tk.Label(acerca_de, text=txt,font = "Arial 20", width=30, height=5)
    acercade.place(x=50, y=200)

#Sale del juego
def Salir():
    menu.destroy()

#Botones del menu
boton_jugar = tk.Button(menu, text="Jugar",font = "Arial 20", width=8, height=1, command = Jugar)
boton_jugar.place(x=225, y=150)
boton_configurar = tk.Button(menu, text="Configurar",font = "Arial 20", width=8, height=1, command = Configurar)
boton_configurar.place(x=225, y=230)
boton_ayuda = tk.Button(menu, text="Ayuda",font = "Arial 20", width=8, height=1, command = Ayuda)
boton_ayuda.place(x=225, y=310)
boton_acercade = tk.Button(menu, text="Acerca de",font = "Arial 20", width=8, height=1, command = Acerca_de)
boton_acercade.place(x=225, y=390)
boton_salir = tk.Button(menu, text="Salir",font = "Arial 20", width=8, height=1, command = Salir)
boton_salir.place(x=225, y=470)
# Fin del programa y del menu
menu.mainloop()