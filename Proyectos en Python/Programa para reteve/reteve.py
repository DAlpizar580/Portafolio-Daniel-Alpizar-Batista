import tkinter as tk
import json
from datetime import datetime, timedelta
import os
from reportlab.pdfgen import canvas # Libreria para generar el PD
import smtplib
from email import encoders # Libreria para enviar correos electronicos
from email.mime.base import MIMEBase # Libreria para enviar correos electronicos
from email.mime.multipart import MIMEMultipart # Libreria para enviar correos electronicos
from email.mime.text import MIMEText # Libreria para enviar correos electronicos
from email.mime.application import MIMEApplication # Libreria para enviar correos electronicos

ruta_base = os.path.expanduser('~')  # obtiene la ruta base del usuario
ruta_escritorio = os.path.join(ruta_base, 'Desktop') # concatena con la carpeta del escritorio
ruta_escritorio = ruta_escritorio.replace("\\", "/") # reemplaza las diagonales invertidas por diagonales normales

#Variables globales
cantidad_lineas = 0 #entero entre 1 a 25
hora_inicial = 0 #entero entre 0 a 23
hora_final = 0 #entero entre 0 a 23 y mayor o igual a hora_inicial
maxMinutos_revision = 0 #entero entre 5 y 45
maxDays_reinspeccion = 0 #entero entre 1 a 60
maxCantidad_fallas = 0 #Entero mayor que 0
meses_autocitas = 0 #Entero entre 1 a 12
iva_porcentage = 0 #Flotante entre 0 y 20
tabla_tarifas = {} #Diccionario con llave de tipo string y valor de tipo entero mayor que 0
value1 = 0
value2 = 0

contador_citas = 1
estado_revision = "PENDIENTE"
listalineasdetrabajo = []
fecha_actual = datetime.now().strftime("%Y-%m-%d")
hora_actual = datetime.now().strftime("%H:00")
lista_de_fallas = {}



# Crear ventana
menu = tk.Tk()
menu.title("Revision Tecnica de Vehiculos")
menu.geometry(f"1400x750")

# Arbol Binario

class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierdo = None
        self.derecho = None

class ArbolBinario:
    def __init__(self):
        self.raiz = None

    def insertar(self, valor):
        if self.raiz is None:
            self.raiz = Nodo(valor)
        else:
            self._insertar_recursivo(valor, self.raiz)

    def _insertar_recursivo(self, valor, nodo_actual):
        if valor["clave"] < nodo_actual.valor["clave"]:
            if nodo_actual.izquierdo is None:
                nodo_actual.izquierdo = Nodo(valor)
            else:
                self._insertar_recursivo(valor, nodo_actual.izquierdo)
        else:
            if nodo_actual.derecho is None:
                nodo_actual.derecho = Nodo(valor)
            else:
                self._insertar_recursivo(valor, nodo_actual.derecho)

    def buscar(self, clave):
        return self._buscar_recursivo(clave, self.raiz)

    def _buscar_recursivo(self, clave, nodo_actual):
        if nodo_actual is None or nodo_actual.valor["clave"] == clave:
            return nodo_actual
        if clave < nodo_actual.valor["clave"]:
            return self._buscar_recursivo(clave, nodo_actual.izquierdo)
        else:
            return self._buscar_recursivo(clave, nodo_actual.derecho)

    def to_dict(self):
        return self._to_dict_recursivo(self.raiz)

    def _to_dict_recursivo(self, nodo_actual):
        if nodo_actual is None:
            return None
        nodo = {
            "valor": nodo_actual.valor,
            "izquierdo": self._to_dict_recursivo(nodo_actual.izquierdo),
            "derecho": self._to_dict_recursivo(nodo_actual.derecho)
        }
        return nodo

    @classmethod
    def from_dict(cls, data):
        arbol = cls()
        arbol.raiz = arbol._from_dict_recursivo(data)
        return arbol.raiz

    def _from_dict_recursivo(self, data):
        if data is None:
            return None
        nodo = Nodo(data["valor"])
        nodo.izquierdo = self._from_dict_recursivo(data["izquierdo"])
        nodo.derecho = self._from_dict_recursivo(data["derecho"])
        return nodo
    
# Guardar arbol en archivo
def guardar_arbol():
    global citas

    estructura_citas = citas.to_dict()

    savedata = [estructura_citas, contador_citas]

    with open("citas.json", "w") as archivo:
        archivo.write(json.dumps(savedata, default=lambda x: x.__dict__))
        archivo.close()

# Cargar arbol desde archivo
def cargar_arbol():
    global citas, contador_citas

    with open("citas.json", "r") as archivo:
        savedata = json.load(archivo)
        estructura_citas = savedata[0]
        contador_citas = savedata[1]
    citas = ArbolBinario()
    citas.raiz = citas.from_dict(estructura_citas)

def programar_citas():
    global value2, contador_citas, check_1, check_2, citas, placa, tipovehiculo, marca, modelo, Propieterio, Telefono, Correo, Direccion, fecha_hora_automatica, programar, menu, estado_revision, cantidad_lineas, hora_inicial, hora_final, maxMinutos_revision, maxDays_reinspeccion, maxCantidad_fallas, meses_autocitas, iva_porcentage, tabla_tarifas, citas, contador_citas

    #variables
    check_1 = None
    check_2 = None
    value2 = ''

    # Funciones

    def checkbutton_handler(btn):
        global check_1, check_2

        if btn == 1 and check_1 == False or check_1 is None:
            check_1 = True
            check_2 = False
            tipo2.deselect()
        elif btn == 2 and check_2 == False or check_2 is None:
            check_1 = False
            check_2 = True
            tipo.deselect()
        elif btn == 1 and check_1 == True:
            check_1 = False
        elif btn == 2 and check_2 == True:
            check_2 = False

    # Recoleccion de datos
    def recolectar_datos():
        global value2, check_1, check_2, contador_citas, listalineasdetrabajo, citas, placa, tipovehiculo, marca, modelo, Propieterio, Telefono, Correo, Direccion, fecha_hora_automatica, estado_revision, citas

        if check_1 == True:
            dattipocita = 'Primera vez'
        elif check_2 == True:
            dattipocita = 'Reinspeccion'
        datplaca = placa.get()
        dattipovehiculo = value1
        datmarca = marca.get()
        datmodelo = modelo.get()
        datpropieterio = Propieterio.get()
        dattelefono = Telefono.get()
        datcorreo = Correo.get()
        datdireccion = Direccion.get()
        if value2 != '':
            datfecha = value2
        else:
            datfecha = fecha_manual.get() + " " + hora_manual.get()


        # Insertar datos en el arbol
        citas.insertar({"clave": contador_citas, "tipocit": dattipocita, "placa": datplaca, "estado": estado_revision, "tipoVehiculo": dattipovehiculo, "marca": datmarca, "modelo": datmodelo, "propietario": datpropieterio, "telefono": dattelefono, "correo": datcorreo, "direccion": datdireccion, "fecha": datfecha, "lineasDeTrabajo": listalineasdetrabajo, "estado": 'PENDIENTE', "observaciones": ''})

        # Guaradar arbol en archivo
        contador_citas+=1
        guardar_arbol()

        volver()
        
    # Comprobar si una fecha en formato (YYYY-MM-DD) es menor a otra
    def fecha_menor(fecha1, fecha2):
        if fecha1 == None or fecha2 == None:
            return False
        else:
            fecha1 = datetime.strptime(fecha1, "%Y-%m-%d")
            fecha2 = datetime.strptime(fecha2, "%Y-%m-%d")
            if fecha1 < fecha2:
                return True
            else:
                return False

    # Comprobar que los datos sean correctos y todos los campos esten llenos
    def comprobar_datos():
        global value1, value2, check_1, check_2, contador_citas, listalineasdetrabajo, citas, placa, tipovehiculo, marca, modelo, Propieterio, Telefono, Correo, Direccion, fecha_hora_automatica, estado_revision

        if check_1 == False and check_2 == False or check_1 == None and check_2 == None:
            errorWindow("Debe seleccionar el tipo de cita")
        elif placa.get() == "" or len(placa.get()) < 1 or len(placa.get()) > 7:
            errorWindow("Debe ingresar la placa del vehiculo correctamente")
        elif value1 == '':
            errorWindow("Debe seleccionar el tipo de vehiculo")
        elif marca.get() == "" or len(marca.get()) < 3 or len(marca.get()) > 15:
            errorWindow("Debe ingresar la marca del vehiculo correctamente")
        elif modelo.get() == "" or len(modelo.get()) < 1 or len(modelo.get()) > 15:
            errorWindow("Debe ingresar el modelo del vehiculo")
        elif Propieterio.get() == "" or len(Propieterio.get()) < 6 or len(Propieterio.get()) > 40:
            errorWindow("Debe ingresar el nombre del propieterio")
        elif Telefono.get() == "" or len(Telefono.get()) != 20:
            errorWindow("Debe ingresar el numero de telefono del propieterio correctamente")
        elif Correo.get() == "":
            errorWindow("Debe ingresar el correo del propieterio")
        elif Direccion.get() == "" or len(Direccion.get()) < 10 or len(Direccion.get()) > 40:
            errorWindow("Debe ingresar la direccion del propieterio")
        elif value2 == '' and fecha_manual.get() == "" and hora_manual.get() == "":
            errorWindow("Debe seleccionar la fecha y hora de la cita")
        elif value2 == '' and fecha_menor(fecha_manual.get(), datetime.now().strftime("%Y-%m-%d")):
            errorWindow("La fecha de la cita no puede ser menor a la fecha actual")
        elif value2 == '' and (int(hora_manual.get()[:2]) < int(hora_inicial) or int(hora_manual.get()[:2]) > int(hora_final)):
            errorWindow("La hora de la cita no puede ser menor a la hora inicial o mayor a la hora final")
        elif comprobar_citas('manual', fecha_manual.get() + " " + hora_manual.get()) == False:
            errorWindow("No se puede agendar la cita en esta fecha y hora" )
        elif comprobar_placa(placa.get()) == False:
            errorWindow("La placa ya tiene una cita agendada")
        else:
            recolectar_datos()

    # Comprobar que no haya mas de cantidad_lineas de citas en la misma fecha y hora
    def comprobar_citas(tipohora, fechahora):
        global value2, citas, cantidad_lineas, fecha_manual, hora_manual
        
        contador = 0

        if tipohora == 'automatico':
            for i in range(contador_citas):
                try:
                    nodo = citas.buscar(i)
                    fechita = nodo.valor["fecha"]
                    if fechita == fechahora:
                        contador += 1
                except:
                    pass
            
            if contador >= int(cantidad_lineas):
                return False
            else:
                return True
        elif tipohora == 'manual':
            for i in range(contador_citas):
                try:
                    nodo = citas.buscar(i)
                    fechita = nodo.valor["fecha"]
                    if fechita == fechahora:
                        contador += 1
                except:
                    pass
            
            if contador >= int(cantidad_lineas):
                return False
            else:
                return True
            
    def comprobar_placa(placa):
        global citas, contador_citas

        for i in range(contador_citas):
            try:
                nodo = citas.buscar(i)
                if nodo.valor["placa"] == placa and nodo.valor["tipocita"] == "Primera Vez":
                    return False
                elif nodo.valor["placa"] == placa and nodo.valor["tipocita"] == "Reinspeccion":
                    return False
            except:
                pass
        return True
        

    def errorWindow(msg):
        error = tk.Tk()
        error.title("Error")
        # centrar la ventana con geometry con respecto a la anterior de 600x200
        error.geometry(f"600x200+{int(error.winfo_screenwidth()/2 - 600/2)}+{int(error.winfo_screenheight()/2 - 200/2)}")
        label = tk.Label(error, text="No se pudo programar la cita", font="Arial 18 bold")
        label.pack(side="top", fill="x", pady=10)
        label = tk.Label(error, text=msg, font="Arial 15")
        label.pack(side="top", fill="x", pady=10)
        button = tk.Button(error, text="OK", command=error.destroy, font="Arial 15")
        button.pack()

        error.mainloop()
    # Ventana

    menu.withdraw()

    programar = tk.Tk()
    programar.title("Programar Citas")
    programar.geometry(f"1400x750")
    
    instruccion = tk.Label(programar, text="Rellene la informacion solicitada", font = "Arial 40 bold")
    instruccion.place(x=620, y=50, anchor="center")
    ncita = tk.Label(programar, text=f"Numero de cita: {contador_citas}", font = "Arial 15")
    ncita.place(x=150, y=100, anchor="center")
    tipo = tk.Checkbutton(programar, text = "Primera vez", font = "Arial 15", command=lambda: checkbutton_handler(1))
    tipo.place(x=135, y=130, anchor="center")
    tipo2 = tk.Checkbutton(programar, text = "Reinspección", font = "Arial 15", command=lambda: checkbutton_handler(2))
    tipo2.place(x=140, y=160, anchor="center")
    labelplaca = tk.Label(programar, text="Placa: ", font = "Arial 15")
    labelplaca.place(x=100, y=190, anchor="center")
    placa = tk.Entry(programar)
    placa.place(x=200, y=190, anchor="center")
    labeltipovehiculo = tk.Label(programar, text="Tipo de vehiculo: ", font = "Arial 15")
    labeltipovehiculo.place(x=145, y=220, anchor="center")
    tipovehiculo = tk.Listbox(programar, font = "Arial 15", width=62)
    def seleccion1(event):
        index = tipovehiculo.curselection()

        if index:
            global value1
            value1 = tipovehiculo.get(index)
    tipovehiculo.bind('<<ListboxSelect>>', seleccion1)
    tipovehiculo.insert(1, "Automovil o vehiculo de carga liviana (Menor o igual a 3500kg)")
    tipovehiculo.insert(2, "Automovil o vehiculo de carga liviana (Mayor a 3500kg pero menor a 8000kg)")
    tipovehiculo.insert(3, "Vehiculo de carga pesada y cabezales (Mayor o igual a 8000kg)")
    tipovehiculo.insert(4, "Taxi")
    tipovehiculo.insert(5, "Autobus, bus, microbus")
    tipovehiculo.insert(6, "Motocicleta")
    tipovehiculo.insert(7, "Equipo especial de obras")
    tipovehiculo.insert(8, "Equipo especial agricola")
    tipovehiculo.place(x=415, y=360, anchor="center")
    labelmarca = tk.Label(programar, text="Marca: ", font = "Arial 15")
    labelmarca.place(x=110, y=500, anchor="center")
    marca = tk.Entry(programar)
    marca.place(x=210, y=500, anchor="center")
    labelmodelo = tk.Label(programar, text="Modelo: ", font = "Arial 15")
    labelmodelo.place(x=110, y=530, anchor="center")
    modelo = tk.Entry(programar)
    modelo.place(x=210, y=530, anchor="center")
    labelPropieterio = tk.Label(programar, text="Propieterio: ", font = "Arial 15")
    labelPropieterio.place(x=125, y=560, anchor="center")
    Propieterio = tk.Entry(programar)
    Propieterio.place(x=240, y=560, anchor="center")
    labelTelefono = tk.Label(programar, text="Telefono: ", font = "Arial 15")
    labelTelefono.place(x=115, y=590, anchor="center")
    Telefono = tk.Entry(programar)
    Telefono.place(x=220, y=590, anchor="center")
    labelCorreo = tk.Label(programar, text="Correo: ", font = "Arial 15")
    labelCorreo.place(x=110, y=620, anchor="center")
    Correo = tk.Entry(programar)
    Correo.place(x=210, y=620, anchor="center")
    labelDireccion = tk.Label(programar, text="Direccion: ", font = "Arial 15")
    labelDireccion.place(x=115, y=650, anchor="center")
    Direccion = tk.Entry(programar)
    Direccion.place(x=220, y=650, anchor="center")
    fecha_hora = tk.Label(programar, text=f"Ingrese manualmente fecha y hora: ", font = "Arial 15")
    fecha_hora.place(x=900, y=100, anchor="center")
    labelfecha_manual = tk.Label(programar, text="Fecha: (yyyy-mm-dd)", font = "Arial 15")
    labelfecha_manual.place(x=952, y=130, anchor="center")
    fecha_manual = tk.Entry(programar)
    fecha_manual.place(x=1130, y=130, anchor="center")
    labelhora_manual = tk.Label(programar, text="Hora: (hh:mm)", font = "Arial 15")
    labelhora_manual.place(x=947, y=160, anchor="center")
    hora_manual = tk.Entry(programar)
    hora_manual.place(x=1125, y=160, anchor="center")
    labelfecha_hora_automatica = tk.Label(programar, text="Fechas y horas automaticas disponibles: ", font = "Arial 15")
    labelfecha_hora_automatica.place(x=1017, y=190, anchor="center")

    # Fechas y horas disponibles

    # Posibles citas

    citas_posibles = (int(hora_final) - int(hora_inicial)) * 60 // int(maxMinutos_revision)
    

    # Variables
    fecha_hora_automatica = tk.Listbox(programar, font = "Arial 15")

    def seleccion2(event):
        index = fecha_hora_automatica.curselection()
        if index:
            global value2
            value2 = fecha_hora_automatica.get(index)

    fecha_hora_automatica.bind('<<ListboxSelect>>', seleccion2)


    horaact = hora_actual[:2]
    day = 1
    fecha_ac = datetime.now().date()

    for day in range(0,30):
        dia = str(fecha_ac + timedelta(days=day))
        hora = int(hora_inicial)
        minutos = 0
        for i in range(citas_posibles):
                minutos = int(minutos) + int(maxMinutos_revision)
                hora = int(hora)
                if minutos >= 60:
                    minutos = minutos - 60
                    hora += 1
                if minutos == 0:
                    minutos = '00'
                if hora > int(horaact):
                    if hora <= 9 :
                            hora = '0' + str(hora)
                    if comprobar_citas('automatico', dia + ' ' + str(hora)+ ':' + str(minutos)):
                        fecha_hora_automatica.insert(i, dia + ' ' + str(hora)+ ':' + str(minutos))
        horaact = hora_inicial[:2]

    fecha_hora_automatica.place(x=837,y=220)

    Aceptar = tk.Button(programar, text="Crear cita", width=8, height=1, font = "Arial 20", bg = "#DADADA", command=comprobar_datos)
    Aceptar.place(x=850,y=500)

    def volver():
        menu.deiconify()
        programar.destroy()
    Volver = tk.Button(programar, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)

    # Setear valores de prueba

    placa.insert(0, "ABC123")
    # tipovehiculo.insert(0, "Automovil o vehiculo de carga liviana (Mayor a 3500kg pero menor a 8000kg)")
    marca.insert(0, "Toyota")
    modelo.insert(0, "Corolla")
    Propieterio.insert(0, "Juan Perez")
    Telefono.insert(0, "11111111111111111111")
    Correo.insert(0, "ledvin25@hotmail.es")
    Direccion.insert(0, "Calle 1 # 1-1")
    fecha_manual.insert(0, "2023-06-18")
    hora_manual.insert(0, "18:00")

    programar.mainloop()

def cancelar_citas():

    global citas, contador_citas

    # Funciones

    def eliminar_cita():
        notfound = False

        for i in range(contador_citas):
            try:
                nodo = citas.buscar(i)
                if nodo.valor["clave"] == int(ncita.get()) and nodo.valor["placa"] == placa.get() and (nodo.valor["estado"] == "PENDIENTE" or nodo.valor["estado"] == "cola de espera"):
                    nodo.valor["estado"] = "CANCELADA"
                    break
                else:
                    notfound = True
            except:
                pass
        if notfound:
            # ventana de no encontrado
            
            notfoundWindow = tk.Tk()
            notfoundWindow.title("No encontrado")
            notfoundWindow.geometry(f"400x200+{cancelar.winfo_x() + 500}+{cancelar.winfo_y() + 200}")
            notfoundWindow.resizable(0,0)

            label_notfound = tk.Label(notfoundWindow, text="No se encontro la cita", font = "Arial 15")
            label_notfound.place(x=200, y=50, anchor="center")

            def cerrar():
                notfoundWindow.destroy()

            boton_cerrar = tk.Button(notfoundWindow, text="Cerrar", font = "Arial 15", command=cerrar)
            boton_cerrar.place(x=200, y=100, anchor="center")

            notfoundWindow.mainloop()
        else:
            guardar_arbol()

    # Ventana de confirmacion

    def confirmar_cancelacion():
        confirmacion = tk.Tk()
        confirmacion.title("Confirmacion")
        # centrar ventana con geometry al centro de la ventana previa
        confirmacion.geometry(f"400x200+{cancelar.winfo_x() + 500}+{cancelar.winfo_y() + 200}")
        confirmacion.resizable(0,0)

        label_confirmacion = tk.Label(confirmacion, text="¿Esta seguro que desea cancelar la cita?", font = "Arial 15")
        label_confirmacion.place(x=200, y=50, anchor="center")

        def si():
            eliminar_cita()
            confirmacion.destroy()
            cancelar.destroy()
            menu.deiconify()
        
        def no():
            confirmacion.destroy()

        boton_confirmar = tk.Button(confirmacion, text="Confirmar", font = "Arial 15", command=si)
        boton_confirmar.place(x=150, y=150, anchor="center")
        boton_cancelar = tk.Button(confirmacion, text="Cancelar", font = "Arial 15", command=no)
        boton_cancelar.place(x=250, y=150, anchor="center")

        confirmacion.mainloop()


    # Ventana
    cancelar = tk.Tk()
    cancelar.title("Cancelar Citas")
    cancelar.geometry(f"1400x750")

    menu.withdraw()

    instruccion = tk.Label(cancelar, text="Escriba los datos de la cita que desea cancelar", font = "Arial 40 bold")
    instruccion.place(x=670, y=60, anchor="center")

    labelncita = tk.Label(cancelar, text="Numero de cita: ", font = "Arial 25")
    labelncita.place(x=200, y=250, anchor="center")
    ncita = tk.Entry(cancelar, font = "Arial 25")
    ncita.place(x=500, y=250, anchor="center")
    labelplaca = tk.Label(cancelar, text="Placa: ", font = "Arial 25")
    labelplaca.place(x=132, y=300, anchor="center")
    placa = tk.Entry(cancelar, font = "Arial 25")
    placa.place(x=360, y=300, anchor="center")

    Aceptar = tk.Button(cancelar, text="Cancelar", width=8, height=1, font = "Arial 20", bg = "#DADADA", command=confirmar_cancelacion)
    Aceptar.place(x=100,y=350)

    def volver():
        menu.deiconify()
        cancelar.destroy()
    Volver = tk.Button(cancelar, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)
    
    cancelar.mainloop()

#guardar cola de espera en JSON
def guardar_cola_espera():
    
    global cola_de_espera
    with open("cola_de_espera.json", "w") as file:
        json.dump(cola_de_espera, file)

#Cargar cola de espera en JSON
def cargar_cola_espera():
    global cola_de_espera
    # comprueba si el archivo existe
    try:
        with open("cola_de_espera.json", "r") as file:
            cola_de_espera = json.load(file)
    except:
        pass

# Guardar cola de revisión en JSON
def guardar_cola_revision():
    global cola_de_revision
    with open("cola_de_revision.json", "w") as file:
        json.dump(cola_de_revision, file)

# Cargar cola de revisión en JSON
def cargar_cola_revision():
    global cola_de_revision
    # comprueba si el archivo existe
    try:
        with open("cola_de_revision.json", "r") as file:
            cola_de_revision = json.load(file)
    except:
        pass

def ingreso():
    global cola_de_espera
    #cargar_cola_espera()
    # Funciones

    # comprobar cual cola de espera tiene menos vehiculos

    def add_cola_espera():
        global cola_de_espera

        cola_menor = 0

        for i,cola in enumerate(cola_de_espera):
            if len(cola_de_espera[i]) == 0:
                cola_de_espera[i].insert(0, placa.get())
                do = False
                break
            else:
                if len(cola_de_espera[i]) < len(cola_de_espera[cola_menor]):
                    cola_menor = i

        if do: cola_de_espera[cola_menor].insert(0, placa.get()) 

        guardar_cola_espera()
                
    def comprobar_datos():
        for i in range(contador_citas):
            try:
                nodo = citas.buscar(i)
                fechanodo = int(nodo.valor["fecha"][11:13]) - 1
                if nodo.valor["clave"] == int(ncita.get()) and nodo.valor["placa"] == placa.get() and nodo.valor["estado"] == "PENDIENTE" and nodo.valor["fecha"][:10] == fecha_actual and fechanodo < int(hora_actual[:2]):
                    # comprobar si el vehiculo ya esta en la cola de espera
                    for cola in cola_de_espera:
                        if placa.get() in cola:
                            notfound = True
                            break
                    
                    nodo.valor["estado"] = "cola de espera"

                    vehitipo = nodo.valor["tipoVehiculo"]
                    costo = int(tabla_tarifas[vehitipo]) + (int(tabla_tarifas[vehitipo]) * (float(iva_porcentage)/100))
                    marca = nodo.valor["marca"]
                    modelo = nodo.valor["modelo"]
                    propietario = nodo.valor["propietario"]
                    notfound = False
                    
                    break
                    
            except:
                notfound = True

        if notfound:
            # ventana de no encontrado
            
            notfoundWindow = tk.Tk()
            notfoundWindow.title("No encontrado")
            notfoundWindow.geometry(f"400x200+{ingreso.winfo_x() + 500}+{ingreso.winfo_y() + 200}")
            notfoundWindow.resizable(0,0)

            label_notfound = tk.Label(notfoundWindow, text="No se encontro la cita", font = "Arial 15")
            label_notfound.place(x=200, y=50, anchor="center")

            def cerrar():
                notfoundWindow.destroy()

            boton_cerrar = tk.Button(notfoundWindow, text="Cerrar", font = "Arial 15", command=cerrar)
            boton_cerrar.place(x=200, y=100, anchor="center")

            notfoundWindow.mainloop()
        else:
            guardar_arbol()
            add_cola_espera()
            datos = tk.Frame(ingreso, borderwidth=1, relief="solid", bg = "#DADADA")
            datos.place(x=390, y=370, anchor="center")

            marca = tk.Label(datos, text="Marca: " + marca, font = "Arial 25", bg = "#DADADA")
            marca.grid(row=0,column=0, sticky="W")
            modelo = tk.Label(datos, text="Modelo: "+modelo, font = "Arial 25", bg = "#DADADA")
            modelo.grid(row=5,column=0, sticky="W")
            propietario = tk.Label(datos, text="Propietario: "+propietario, font = "Arial 25", bg = "#DADADA")
            propietario.grid(row=6,column=0, sticky="W")
            costo = tk.Label(datos, text="Costo: "+str(costo), font = "Arial 25", bg = "#DADADA")
            costo.grid(row=7,column=0, sticky="W")

            # boton ok

            def ok():
                ingreso.destroy()
                menu.deiconify()

            ok = tk.Button(datos, text="Ok", font = "Arial 15", command=ok)
            ok.grid(row=8,column=0, sticky="W")
            
            datos.mainloop()

    # Ventana
    ingreso = tk.Tk()
    ingreso.title("Cancelar Citas")
    ingreso.geometry(f"1400x750")

    menu.withdraw()

    instruccion = tk.Label(ingreso, text="Escriba los datos de su la cita", font = "Arial 40 bold")
    instruccion.place(x=670, y=50, anchor="center")

    labelncita = tk.Label(ingreso, text="Numero de cita: ", font = "Arial 25")
    labelncita.place(x=200, y=150, anchor="center")
    ncita = tk.Entry(ingreso, font = "Arial 25")
    ncita.place(x=500, y=150, anchor="center")
    labelplaca = tk.Label(ingreso, text="Placa: ", font = "Arial 25")
    labelplaca.place(x=132, y=200, anchor="center")
    placa = tk.Entry(ingreso, font = "Arial 25")
    placa.place(x=360, y=200, anchor="center")

    Aceptar = tk.Button(ingreso, text="Ingresar", width=8, height=1, font = "Arial 20", bg = "#DADADA",command= comprobar_datos)
    Aceptar.place(x=750,y=150)

    def volver():
        menu.deiconify()
        ingreso.destroy()
    Volver = tk.Button(ingreso, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)

    ingreso.mainloop()

def tablero():

    global lineasdetrabajo, listalineasdetrabajo, cola_de_espera, cola_de_revision, lista_de_fallas

    cargar_cola_espera()
    cargar_cola_revision()

    # Funciones
    def actualizar_colas():
        #Limpiar tablero
        for puesto in listalineasdetrabajo:
            for posicion in puesto:
                posicion.config(text="------")

        for puesto, cola in zip(listalineasdetrabajo, cola_de_revision):
            for posicion, vehiculo in enumerate(cola):
                if vehiculo != None:
                    puesto[posicion].config(text=vehiculo)

    # avanzar en la cola de espera
    def avanzar_espera(num):
        global cola_de_espera, cola_de_revision
        placa = num[1:7]

        for cola in cola_de_espera:
            if placa in cola:
            # revisar que este de primero
                if cola.index(placa) <=5 and cola_de_revision and cola_de_revision[cola_de_espera.index(cola)][4] == None:
                    cola_de_revision[cola_de_espera.index(cola)].insert(5, cola.pop(cola.index(placa)))
                    cola_de_revision[cola_de_espera.index(cola)].pop(0)
                    break
                else:
                    #Ventana de error
                    error = tk.Tk()
                    error.title("Error")
                    error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
                    error.resizable(0,0)

                    label_error = tk.Label(error, text="El vehiculo no esta en la cola de espera\nO el puesto 1 no esta libre", font = "Arial 15")
                    label_error.place(x=200, y=50, anchor="center")

                    def cerrar():
                        error.destroy()

                    boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
                    boton_cerrar.place(x=200, y=100, anchor="center")

                    error.mainloop()
            else:
                #Ventana de error
                error = tk.Tk()
                error.title("Error")
                error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
                error.resizable(0,0)

                label_error = tk.Label(error, text="No se encontro el vehiculo", font = "Arial 15")
                label_error.place(x=200, y=50, anchor="center")

                def cerrar():
                    error.destroy()

                boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
                boton_cerrar.place(x=200, y=100, anchor="center")

                error.mainloop()

        actualizar_colas()

    # Avanzar en la cola de revision
    def avanzar_revision(num):
        global cola_de_revision
        placa = num[1:7]

        for cola in cola_de_revision:
            if placa in cola:
                if cola.index(placa) == 0:
                    error = tk.Tk()
                    error.title("Error")
                    error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
                    error.resizable(0,0)

                    label_error = tk.Label(error, text="El vehiculo esta en el ultimo puesto\nUse F + Placa para finalizar", font = "Arial 15")
                    label_error.place(x=200, y=50, anchor="center")

                    def cerrar():
                        error.destroy()

                    boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
                    boton_cerrar.place(x=200, y=100, anchor="center")

                    error.mainloop()
                    break
                elif cola.index(placa) <=5 and cola[cola.index(placa)] != 0 and cola[cola.index(placa) - 1] == None:
                    cola.insert(cola.index(placa) - 1,(cola.pop(cola.index(placa))))
                    break
                else:
                    #Ventana de error
                    error = tk.Tk()
                    error.title("Error")
                    error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
                    error.resizable(0,0)

                    label_error = tk.Label(error, text="El vehiculo no en la cola de revision\nO el siguiente espacio no esta libre", font = "Arial 15")
                    label_error.place(x=200, y=50, anchor="center")

                    def cerrar():
                        error.destroy()

                    boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
                    boton_cerrar.place(x=200, y=100, anchor="center")

                    error.mainloop()
            else:
                #Ventana de error
                error = tk.Tk()
                error.title("Error")
                error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
                error.resizable(0,0)

                label_error = tk.Label(error, text="No se encontro el vehiculo", font = "Arial 15")
                label_error.place(x=200, y=50, anchor="center")

                def cerrar():
                    error.destroy()

                boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
                boton_cerrar.place(x=200, y=100, anchor="center")

                error.mainloop()

        actualizar_colas()

    # Agregar falla

    def agregar_falla(num):
        global cola_de_revision

        placa = num[1:7]
        falla = num[7:]

        for i in range(contador_citas):
            try:
                nodo = citas.buscar(i)
                if nodo.valor["placa"] == placa:
                    if nodo.valor["observaciones"] == "":
                        nodo.valor["observaciones"] = [falla]
                        guardar_arbol()
                        notfound = False
                    else:
                        nodo.valor["observaciones"].append(falla)
                        guardar_arbol()
                        notfound = False
                    break
                else:
                    notfound = True
            except:
                pass

        if notfound:
            #Ventana de error
            error = tk.Tk()
            error.title("Error")
            error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
            error.resizable(0,0)

            label_error = tk.Label(error, text="No se encontro el vehiculo", font = "Arial 15")
            label_error.place(x=200, y=50, anchor="center")

            def cerrar():
                error.destroy()

            boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
            boton_cerrar.place(x=200, y=100, anchor="center")

            error.mainloop()
        else:
            #ventana de exito
            exito = tk.Tk()
            exito.title("Exito")
            exito.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
            exito.resizable(0,0)

            label_exito = tk.Label(exito, text="Se agrego la falla", font = "Arial 15")
            label_exito.place(x=200, y=50, anchor="center")

            def cerrar():
                exito.destroy()

            boton_cerrar = tk.Button(exito, text="Cerrar", font = "Arial 15", command=cerrar)
            boton_cerrar.place(x=200, y=100, anchor="center")

            exito.mainloop()

        
    # Final del proceso

    def finalizar(num):
        global cola_de_revision, cola_de_espera, lista_de_fallas
        placa = num[1:7]

        leves = graves = 0
        # comprobar que este en el ultimo puesto
        for cola in cola_de_revision:
            if placa in cola:
                if cola.index(placa) == 0:
                    for i in range(contador_citas):
                        try:
                            nodo = citas.buscar(i)
                            if nodo.valor["placa"] == placa :
                                
                                for key in lista_de_fallas:
                                    for i in nodo.valor["observaciones"]:
                                        if int(i) == key:
                                            if lista_de_fallas[key] == "Leve":
                                                leves += 1
                                            else:
                                                graves += 1

                                if graves == 0:
                                    nodo.valor["estado"] = "APROBADO"
                                    certificado(placa)
                                elif graves >= 1 or graves < maxCantidad_fallas:
                                    nodo.valor["estado"] = "REINSPECCION"
                                elif graves >= maxCantidad_fallas:
                                    nodo.valor["estado"] = "SACAR DE CIRCULACION"
                        except:
                            pass
                    guardar_arbol()
                    cola.pop(cola.index(placa))
                    cola.append(None)
                    break
                else:
                    #Ventana de error
                    error = tk.Tk()
                    error.title("Error")
                    error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
                    error.resizable(0,0)

                    label_error = tk.Label(error, text="El vehiculo no esta en el ultimo puesto", font = "Arial 15")
                    label_error.place(x=200, y=50, anchor="center")

                    def cerrar():
                        error.destroy()

                    boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
                    boton_cerrar.place(x=200, y=100, anchor="center")

                    error.mainloop()

        enviar_correo(placa)

    # Comandos

    def comandos(num):
        comando = num[:1]

        if comando == "T":
            avanzar_espera(num)
        elif comando == "U":
            avanzar_revision(num)
        elif comando == "E":
            agregar_falla(num)
        elif comando == "F":
            finalizar(num)
        else:
            #Ventana de error
            error = tk.Tk()
            error.title("Error")
            error.geometry(f"400x200+{tab.winfo_x() + 500}+{tab.winfo_y() + 200}")
            error.resizable(0,0)

            label_error = tk.Label(error, text="Comando no valido", font = "Arial 15")
            label_error.place(x=200, y=50, anchor="center")

            def cerrar():
                error.destroy()

            boton_cerrar = tk.Button(error, text="Cerrar", font = "Arial 15", command=cerrar)
            boton_cerrar.place(x=200, y=100, anchor="center")

            error.mainloop()

        guardar_cola_espera()
        guardar_cola_revision()

        actualizar_colas()

    # Crear resultado

    def resultado(placa):
        yfalla = 0
        pdf = canvas.Canvas(ruta_escritorio + '/resultados.pdf')
        pdf.drawString(50, 800, "RESULTADO REVISION")

        for i in range(contador_citas):
            try:
                nodo = citas.buscar(i)
                if nodo.valor["placa"] == placa:
                    Correo = nodo.valor["correo"]
                    nombre = nodo.valor["propietario"]


                    pdf.drawString(50, 750, "Placa: " + nodo.valor["placa"])
                    pdf.drawString(50, 730, "Fecha: " + nodo.valor["fecha"])
                    pdf.drawString(50, 710, "Estado: " + nodo.valor["estado"])
                    pdf.drawString(50, 690, "Observaciones: ")
                    for key in lista_de_fallas:
                                    for i in nodo.valor["observaciones"]:
                                        if int(i) == key:
                                            falla = lista_de_fallas[key]
                                            pdf.drawString(50, (670 - (20*yfalla)), "Falla: " + falla[0] + " " + falla[1])
                                            yfalla += 1
                            
                    break
            except:
                pass
        pdf.save()     
        return Correo, nombre

    #enviar correo

    def enviar_correo(placa):
        Correo, nombre = resultado(placa)

        msg = MIMEMultipart()
        message = "Hola " + ' '.join(nombre) + ",\n\nAdjunto encontraras un archivo PDF con el resultado de la revision.\n\nSaludos"
        msg.attach(MIMEText(message, 'plain'))

        # setup the parameters of the message 
        password = "gruyqgdcppusqwib"
        msg['From'] = "testledvin25@gmail.com"
        msg['To'] = Correo
        msg['Subject'] = "Resultado de revision - Placa: " + placa

        # add in the message body 
        with open(ruta_escritorio + '/resultados.pdf', 'rb') as f:
            pdf_data = f.read()
        pdf_part = MIMEApplication(pdf_data, 'pdf', Name=ruta_escritorio + 'resultados.pdf')
        pdf_part['Content-Disposition'] = 'attachment; filename="resultados.pdf"'
        msg.attach(pdf_part)


        #create server 
        server = smtplib.SMTP('smtp.gmail.com: 587')
        server.starttls()

        # Login Credentials for sending the mail 
        server.login(msg['From'], password)

        # send the message via the server. 
        server.sendmail(msg['From'], msg['To'], msg.as_string())
        server.quit()

        os.remove(ruta_escritorio + '/resultados.pdf')

    # Crear Certificado de revision

    def certificado(placa):
        pdf = canvas.Canvas(ruta_escritorio + '/certificado.pdf')
        pdf.drawString(50, 800, "CERTIFICADO REVISION")

        for i in range(contador_citas):
            try:
                nodo = citas.buscar(i)
                if nodo.valor["placa"] == placa:
                    pdf.drawString(50, 750, "Placa: " + nodo.valor["placa"])
                    pdf.drawString(50, 730, "Marca: " + nodo.valor["marca"])
                    pdf.drawString(50, 710, "Modelo: " + nodo.valor["modelo"])
                    pdf.drawString(50, 690, "Tipo de vehiculo: " + nodo.valor["tipoVehiculo"])
                    pdf.drawString(50, 670, "Propietario: " + nodo.valor["propietario"])

                    # Vigencia hasta dentro de 1 año

                    fecha_ac = datetime.now().date()
                    anio = str(fecha_ac + timedelta(days=365))

                    pdf.drawString(50, 650, "Vigencia hasta: " + anio)
                    break
            except:
                pass
        pdf.save()

    # Ventana
    tab = tk.Tk()
    tab.title("Cancelar Citas")
    tab.geometry(f"1200x650")

    menu.withdraw()

    titulo = tk.Label(tab, text="Tablero de citas", font = "Arial 50 bold")
    titulo.place(x=640, y=50, anchor="center")

    ncita = tk.Label(tab, text=f"Fecha: " + fecha_actual, font = "Arial 25")
    ncita.place(x=200, y=100, anchor="center")

    frametab = tk.Frame(tab, borderwidth=1, relief="solid", bg = "#DADADA")
    frametab.place(x=570, y=300, anchor="center")

    Linea = tk.Label(frametab, text="Linea     ", font = "Arial 25", bg = "#DADADA")
    Linea.grid(row=0,column=0)
    Puesto1 = tk.Label(frametab, text="Puesto 5     ", font = "Arial 25", bg = "#DADADA")
    Puesto1.grid(row=0,column=1)
    Puesto2 = tk.Label(frametab, text="Puesto 4     ", font = "Arial 25", bg = "#DADADA")
    Puesto2.grid(row=0,column=2)
    Puesto3 = tk.Label(frametab, text="Puesto 3     ", font = "Arial 25", bg = "#DADADA")
    Puesto3.grid(row=0,column=3)
    Puesto4 = tk.Label(frametab, text="Puesto 2     ", font = "Arial 25", bg = "#DADADA")
    Puesto4.grid(row=0,column=4)
    Puesto5 = tk.Label(frametab, text="Puesto 1     ", font = "Arial 25", bg = "#DADADA")
    Puesto5.grid(row=0,column=5)

    l1 = tk.Label(frametab, text="1", font = "Arial 25", bg = "#DADADA")
    l1.grid(row=1,column=0)
    l2 = tk.Label(frametab, text="2", font = "Arial 25", bg = "#DADADA")
    l2.grid(row=2,column=0)
    l3 = tk.Label(frametab, text="3", font = "Arial 25", bg = "#DADADA")
    l3.grid(row=3,column=0)
    l4 = tk.Label(frametab, text="4", font = "Arial 25", bg = "#DADADA")
    l4.grid(row=4,column=0)
    l5 = tk.Label(frametab, text="5", font = "Arial 25", bg = "#DADADA")
    l5.grid(row=5,column=0)
    l6 = tk.Label(frametab, text="6", font = "Arial 25", bg = "#DADADA")
    l6.grid(row=6,column=0)

    for i in range(1,int(cantidad_lineas)+1):
        p1 = tk.Label(frametab, text="------", font = "Arial 25", bg = "#DADADA")
        p1.grid(row=i,column=1)
        p2 = tk.Label(frametab, text="------", font = "Arial 25", bg = "#DADADA")
        p2.grid(row=i,column=2)
        p3 = tk.Label(frametab, text="------", font = "Arial 25", bg = "#DADADA")
        p3.grid(row=i,column=3)
        p4 = tk.Label(frametab, text="------", font = "Arial 25", bg = "#DADADA")
        p4.grid(row=i,column=4)
        p5 = tk.Label(frametab, text="------", font = "Arial 25", bg = "#DADADA")
        p5.grid(row=i,column=5)

        listalineasdetrabajo.append([p1,p2,p3,p4,p5])

    actualizar_colas()


    labelcomando = tk.Label(tab, text="COMANDO: ", font = "Arial 25")
    labelcomando.place(x=170, y=500, anchor="center")
    comando = tk.Entry(tab, font = "Arial 25")
    comando.place(x=470, y=500, anchor="center")

    def aceptar():
        numero = comando.get()
        comandos(numero)

    Aceptar = tk.Button(tab, text="Aceptar", width=8, height=1, font = "Arial 20", bg = "#DADADA", command=aceptar)
    Aceptar.place(x=670,y=470)

    def volver():
        menu.deiconify()
        tab.destroy()
    Volver = tk.Button(tab, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)

    tab.mainloop()

# Guardar lista de fallas en JSON
def guardar_fallas():
    global lista_de_fallas
    with open("fallas.json", "w") as file:
        json.dump(lista_de_fallas, file)

# Cargar lista de fallas en JSON

def cargar_fallas():
    global lista_de_fallas
    with open("fallas.json", "r") as file:
        lista_de_fallas = json.load(file)

def lista_fallas():

    global lista_de_fallas

    fallas = tk.Tk()
    fallas.title("Lista de Fallas")
    fallas.geometry(f"1400x650")

    menu.withdraw()

    titulo = tk.Label(fallas, text="Lista de Fallas", font = "Arial 50 bold")
    titulo.place(x=670, y=50, anchor="center")

    # Ventana de error
    def error(msg):
        error = tk.Tk()
        error.title("Error")
        # Centrar con geometry en el centro de la ventana anterior
        error.geometry(f"500x200+{error.winfo_screenwidth() // 2 - 250}+{error.winfo_screenheight() // 2 - 100}")
        error.resizable(False, False)
        error.configure(bg="#DADADA")

        # label de error

        labelerror = tk.Label(error, text=msg, font = "Arial 20", bg = "#DADADA")
        labelerror.place(x=250, y=50, anchor="center")

        # Boton de aceptar
        def aceptar():
            error.destroy()

        Aceptar = tk.Button(error, text="Aceptar", width=8, height=1, font = "Arial 20", bg = "#DADADA", command=aceptar)
        Aceptar.place(x=250,y=100, anchor="center")

        error.mainloop()

    def añadir():

        global lista_de_fallas

        # Funciones
        
        # Añadir fallas
        def añadir_falla():
            global lista_de_fallas

            numfalla = nfalla.get()
            description = descripcion.get()
            tipofalla = tipo.get()

            if numfalla in lista_de_fallas:
                error("Numero de falla ya existente")
                return
            elif numfalla == "":
                error("Numero de falla no puede estar vacio")
                return
            elif description == "":
                error("Descripcion no puede estar vacia")
                return
            elif tipofalla == "":
                error("Tipo de falla no puede estar vacio")
                return
            else:
                lista_de_fallas[numfalla] = [description, tipofalla]
                guardar_fallas()

        # ventana
        añadirfallas = tk.Tk()
        añadirfallas.title("Añadir Fallas")
        añadirfallas.geometry(f"1400x650")

        fallas.withdraw()

        titulo = tk.Label(añadirfallas, text="Añadir Fallas", font = "Arial 50 bold")
        titulo.place(x=670, y=50, anchor="center")

        labelnfalla = tk.Label(añadirfallas, text="Numero de falla: ", font = "Arial 25")
        labelnfalla.place(x=170, y=200, anchor="center")
        nfalla = tk.Entry(añadirfallas, font = "Arial 25")
        nfalla.place(x=470, y=200, anchor="center")
        labeldescripcion = tk.Label(añadirfallas, text="Descripcion de falla: ", font = "Arial 25")
        labeldescripcion.place(x=198, y=250, anchor="center")
        descripcion = tk.Entry(añadirfallas, font = "Arial 25")
        descripcion.place(x=520, y=250, anchor="center")
        labeltipo = tk.Label(añadirfallas, text="Tipo de falla: ", font = "Arial 25")
        labeltipo.place(x=145, y=300, anchor="center")
        tipo = tk.Entry(añadirfallas, font = "Arial 25")
        tipo.place(x=415, y=300, anchor="center")

        def aceptar():
            añadir_falla()
            fallas.deiconify()
            añadirfallas.destroy()

        Aceptar = tk.Button(añadirfallas, text="Aceptar", width=8, height=1, font = "Arial 20", bg = "#DADADA",command=aceptar)
        Aceptar.place(x=670,y=470)

        añadirfallas.mainloop()

    def consultar():

        # funciones

        # Consultar fallas
        def consultar_falla():
            global lista_de_fallas

            numfalla = nfalla.get()

            if numfalla not in lista_de_fallas:
                error("Numero de falla no existente")
                return
            elif numfalla == "":
                error("Numero de falla no puede estar vacio")
                return
            else:
                descripcion = lista_de_fallas[numfalla][0]
                tipofalla = lista_de_fallas[numfalla][1]
                datosfallas(descripcion, tipofalla)

        consultarfallas = tk.Tk()
        consultarfallas.title("Consultar Fallas")
        consultarfallas.geometry(f"1400x650")

        fallas.withdraw()

        titulo = tk.Label(consultarfallas, text="Consultar Fallas", font = "Arial 50 bold")
        titulo.place(x=670, y=50, anchor="center")

        labelnfalla = tk.Label(consultarfallas, text="Numero de falla: ", font = "Arial 25")
        labelnfalla.place(x=170, y=150, anchor="center")
        nfalla = tk.Entry(consultarfallas, font = "Arial 25")
        nfalla.place(x=470, y=150, anchor="center")

        def datosfallas(descripcion, tipofalla):
            datosfallas = tk.Frame(consultarfallas, borderwidth=1, relief="solid", bg = "#DADADA")
            datosfallas.place(x=390, y=370, anchor="center")

            Descripcionfalla = tk.Label(datosfallas, text="Descripcion de la falla: " + descripcion, font = "Arial 25", bg = "#DADADA")
            Descripcionfalla.grid(row=0,column=0, sticky="W")
            Tipofalla = tk.Label(datosfallas, text="Tipo de falla:  " + tipofalla, font = "Arial 25", bg = "#DADADA")
            Tipofalla.grid(row=5,column=0, sticky="W")
            

        Aceptar = tk.Button(consultarfallas, text="Consultar", width=8, height=1, font = "Arial 20", bg = "#DADADA",command=consultar_falla)
        Aceptar.place(x=700,y=150)

        def volver():
            fallas.deiconify()
            consultarfallas.destroy()
        Volver = tk.Button(consultarfallas, text="Volver", font="Arial 15",command=volver)
        Volver.place(x=10,y=10)

        consultarfallas.mainloop()


    def modificar():
        global lista_de_fallas, newdescripcion, newtipo

        # funciones

        # Modificar fallas
        def modificar_falla():
            global lista_de_fallas, newdescripcion, newtipo

            numfalla = nfalla.get()
            nuevadescripcion = newdescripcion.get()
            nuevatipofalla = newtipo.get()

            if numfalla not in lista_de_fallas:
                error("Numero de falla no existente")
                return
            elif numfalla == "":
                error("Numero de falla no puede estar vacio")
                return
            elif newdescripcion == "":
                error("Descripcion de falla no puede estar vacio")
                return
            elif nuevatipofalla == "":
                error("Tipo de falla no puede estar vacio")
                return
            else:
                lista_de_fallas[numfalla][0] = nuevadescripcion
                lista_de_fallas[numfalla][1] = nuevatipofalla
                return


        modificarfallas = tk.Tk()
        modificarfallas.title("Modificar Fallas")
        modificarfallas.geometry(f"1400x650")

        fallas.withdraw()

        titulo = tk.Label(modificarfallas, text="Modificar Fallas", font = "Arial 50 bold")
        titulo.place(x=670, y=50, anchor="center")

        labelnfalla = tk.Label(modificarfallas, text="Numero de falla: ", font = "Arial 25")
        labelnfalla.place(x=170, y=150, anchor="center")
        nfalla = tk.Entry(modificarfallas, font = "Arial 25")
        nfalla.place(x=470, y=150, anchor="center")
        
        def modifallas():
            global newdescripcion, newtipo

            modfallas = tk.Frame(modificarfallas, borderwidth=1, relief="solid", bg = "#DADADA")
            modfallas.place(x=390, y=370, anchor="center")

            Descripcionfalla = tk.Label(modfallas, text="Descripcion de la falla: ", font = "Arial 25", bg = "#DADADA")
            Descripcionfalla.grid(row=0,column=0, sticky="W")
            newdescripcion = tk.Entry(modfallas, font = "Arial 25")
            newdescripcion.grid(row=0,column=1, sticky="W")
            Tipofalla = tk.Label(modfallas, text="Tipo de falla:  ", font = "Arial 25", bg = "#DADADA")
            Tipofalla.grid(row=5,column=0, sticky="W")
            newtipo = tk.Entry(modfallas, font = "Arial 25")
            newtipo.grid(row=5,column=1, sticky="W")

            def aceptarmod():
                modificar_falla()
                guardar_fallas()
                fallas.deiconify()
                modificarfallas.destroy()

            Aceptar = tk.Button(modfallas, text="Aceptar", width=8, height=1, font = "Arial 20", bg = "#DADADA",command=aceptarmod)
            Aceptar.grid(row=6,column=0)
            

        Aceptar = tk.Button(modificarfallas, text="Aceptar", width=8, height=1, font = "Arial 20", bg = "#DADADA",command=modifallas)
        Aceptar.place(x=700,y=150)

        

        modificarfallas.mainloop()

    def eliminar():
        # funciones

        # Eliminar fallas
        def eliminar_falla():
            global lista_de_fallas

            numfalla = nfalla.get()

            if numfalla not in lista_de_fallas:
                error("Numero de falla no existente")
                return
            elif numfalla == "":
                error("Numero de falla no puede estar vacio")
                return
            else:
                del lista_de_fallas[numfalla]
                return


        eliminarfallas = tk.Tk()
        eliminarfallas.title("Eliminar Fallas")
        eliminarfallas.geometry(f"1400x650")

        fallas.withdraw()

        titulo = tk.Label(eliminarfallas, text="Eliminar Fallas", font = "Arial 50 bold")
        titulo.place(x=670, y=50, anchor="center")

        labelnfalla = tk.Label(eliminarfallas, text="Numero de falla: ", font = "Arial 25")
        labelnfalla.place(x=170, y=150, anchor="center")
        nfalla = tk.Entry(eliminarfallas, font = "Arial 25")
        nfalla.place(x=470, y=150, anchor="center")

        def aceptar():
            eliminar_falla()
            guardar_fallas()
            fallas.deiconify()
            eliminarfallas.destroy()

        Aceptar = tk.Button(eliminarfallas, text="Aceptar", width=8, height=1, font = "Arial 20", bg = "#DADADA",command=aceptar)
        Aceptar.place(x=700,y=150)

        eliminarfallas.mainloop()

    Añadir = tk.Button(fallas, text="Añadir Fallas", width=15, height=1, font = "Arial 20", bg = "#DADADA", command=añadir)
    Añadir.place(x=535,y=150)
    Consultar = tk.Button(fallas, text="Consultar Fallas", width=15, height=1, font = "Arial 20", bg = "#DADADA",command=consultar)
    Consultar.place(x=535,y=210)
    Modificar = tk.Button(fallas, text="Modificar Fallas", width=15, height=1, font = "Arial 20", bg = "#DADADA", command= modificar)
    Modificar.place(x=535,y=270)
    Eliminar = tk.Button(fallas, text="Eliminar Fallas", width=15, height=1, font = "Arial 20", bg = "#DADADA",command=eliminar)
    Eliminar.place(x=535,y=330)

    def volver():
        menu.deiconify()
        fallas.destroy()
    Volver = tk.Button(fallas, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)

    fallas.mainloop()

def config():
    # Variables globales
    global lineasdetrabajo, cantidad_lineas, hora_inicial, hora_final, maxMinutos_revision, maxDays_reinspeccion, maxCantidad_fallas, meses_autocitas, iva_porcentage, tabla_tarifas

    # Funciones

    # Cargar datos de configuracion
    def cargar():

        # Variables globales
        global cantidad_lineas, hora_inicial, hora_final, maxMinutos_revision, maxDays_reinspeccion, maxCantidad_fallas, meses_autocitas, iva_porcentage, tabla_tarifas

        # Cargar datos
        entrylineasdetrabajo.insert(0, cantidad_lineas)
        horainicial.insert(0, hora_inicial)
        horafinal.insert(0, hora_final)
        mincita.insert(0, maxMinutos_revision)
        maxreinspeccion.insert(0, maxDays_reinspeccion)
        maxfallasgraves.insert(0, maxCantidad_fallas)
        mesesauto.insert(0, meses_autocitas)
        iva.insert(0, iva_porcentage)
        t1.insert(0, tabla_tarifas["Automovil o vehiculo de carga liviana (Menor o igual a 3500kg)"])
        t2.insert(0, tabla_tarifas["Automovil o vehiculo de carga liviana (Mayor a 3500kg pero menor a 8000kg)"])
        t3.insert(0, tabla_tarifas["Vehiculo de carga pesada y cabezales (Mayor o igual a 8000kg)"])
        t4.insert(0, tabla_tarifas["Taxi"])
        t5.insert(0, tabla_tarifas["Autobus, bus, microbus"])
        t6.insert(0, tabla_tarifas["Motocicleta"])
        t7.insert(0, tabla_tarifas["Equipo especial de obras"])
        t8.insert(0, tabla_tarifas["Equipo especial agricola"])

    # Guardar
    def guardar():
        global cantidad_lineas, hora_inicial, hora_final, maxMinutos_revision, maxDays_reinspeccion, maxCantidad_fallas, meses_autocitas, iva_porcentage, tabla_tarifas

        cantidad_lineas = entrylineasdetrabajo.get()
        hora_inicial = horainicial.get()
        hora_final = horafinal.get()
        maxMinutos_revision = mincita.get()
        maxDays_reinspeccion = maxreinspeccion.get()
        maxCantidad_fallas = maxfallasgraves.get()
        meses_autocitas = mesesauto.get()
        iva_porcentage = iva.get()
        tabla_tarifas = {'Automovil o vehiculo de carga liviana (Menor o igual a 3500kg)': t1.get(), 'Automovil o vehiculo de carga liviana (Mayor a 3500kg pero menor a 8000kg)': t2.get(), 'Vehiculo de carga pesada y cabezales (Mayor o igual a 8000kg)': t3.get(), 'Taxi': t4.get(), 'Autobus, bus, microbus': t5.get(), 'Motocicleta': t6.get(), 'Equipo especial de obras':t7.get(), 'Equipo especial agricola':t8.get()}

        #Comprobar que los datos sean correctos
        try:
            if not (isinstance(int(cantidad_lineas), int) and 1 <= int(cantidad_lineas) <= 25):
                raise Exception
            if not (isinstance(int(hora_inicial), int) and 0 <= int(hora_inicial) <= 23):
                raise Exception
            if not (isinstance(int(hora_final), int) and 0 <= int(hora_final) <= 23):
                raise Exception
            if not (isinstance(int(maxMinutos_revision), int) and 5 <= int(maxMinutos_revision) <= 45):
                raise Exception
            if not (isinstance(int(maxDays_reinspeccion), int) and 1 <= int(maxDays_reinspeccion) <= 60):
                raise Exception
            if not (isinstance(int(maxCantidad_fallas), int) and int(maxCantidad_fallas) >= 0):
                raise Exception
            if not (isinstance(int(meses_autocitas), int) and 1 <= int(meses_autocitas) <= 12):
                raise Exception
            if not (isinstance(float(iva_porcentage), float) and 1 <= float(iva_porcentage) <= 20):
                raise Exception

            for key in tabla_tarifas:
                for item in tabla_tarifas[key]: 
                    if not isinstance(int(item), int) and item < 0:
                        raise Exception
        except:
            # Crear ventana de error
            error = tk.Tk()
            error.title("Error")

            # Centrar la ventana en la propiedad geometry
            error.geometry("400x150+{}+{}".format(int(error.winfo_screenwidth() / 2 - 200), int(error.winfo_screenheight() / 2 - 75)))
            error.resizable(False, False)

            labelerror = tk.Label(error, text="Compruebe que los datos sean correctos", font = "Arial 16")
            labelerror.place(x=200, y=50, anchor="center")

            # Boton de aceptar
            Aceptar = tk.Button(error, text="Aceptar", width=8, height=1, font = "Arial 16", bg = "#DADADA", command=lambda: error.destroy())
            Aceptar.place(x=200,y=100,anchor="center")
            return
        
        #Guardar los datos en el archivo de configuracion
        with open('config.json', 'w') as file:
            json.dump({'cantidad_lineas': cantidad_lineas, 'hora_inicial': hora_inicial, 'hora_final': hora_final, 'maxMinutos_revision': maxMinutos_revision, 'maxDays_reinspeccion': maxDays_reinspeccion, 'maxCantidad_fallas': maxCantidad_fallas, 'meses_autocitas': meses_autocitas, 'iva_porcentage': iva_porcentage, 'tabla_tarifas': tabla_tarifas}, file)

        # Crear ventana de guardado exitoso
        exito = tk.Tk()
        exito.title("Guardado exitoso")
        exito.geometry("400x150+{}+{}".format(int(exito.winfo_screenwidth() / 2 - 200), int(exito.winfo_screenheight() / 2 - 75)))
        exito.resizable(False, False)

        labelexito = tk.Label(exito, text="Guardado exitoso", font = "Arial 16")
        labelexito.place(x=200, y=50, anchor="center")

        def cerrar():
            exito.destroy()
            configuracion.destroy()
            menu.deiconify()

        # Boton de aceptar
        Aceptar = tk.Button(exito, text="Aceptar", width=8, height=1, font = "Arial 16", bg = "#DADADA", command=cerrar)
        Aceptar.place(x=200,y=100,anchor="center")

        exito.mainloop()


    # Ventana

    configuracion = tk.Tk()
    configuracion.title("Cancelar Citas")
    configuracion.geometry(f"1400x650")

    menu.withdraw()

    titulo = tk.Label(configuracion, text="Configuracion", font = "Arial 50 bold")
    titulo.place(x=670, y=50, anchor="center")

    labellineasdetrabajo = tk.Label(configuracion, text="Lineas de trabajo: ", font = "Arial 15")
    labellineasdetrabajo.place(x=150, y=150, anchor="center")
    entrylineasdetrabajo = tk.Entry(configuracion, font = "Arial 15")
    entrylineasdetrabajo.place(x=350, y=150, anchor="center")

    horario = tk.Label(configuracion, text="Horario de la estacion: ", font = "Arial 15")
    horario.place(x=170, y=200, anchor="center")
    labelhorainicial = tk.Label(configuracion, text="Hora inicial (en 24h): ", font = "Arial 15")
    labelhorainicial.place(x=120, y=250, anchor="center")
    horainicial = tk.Entry(configuracion, font = "Arial 15")
    horainicial.place(x=280, y=250, anchor="center")
    labelhorafinal = tk.Label(configuracion, text="Hora final (en 24h): ", font = "Arial 15")
    labelhorafinal.place(x=116, y=300, anchor="center")
    horafinal = tk.Entry(configuracion, font = "Arial 15")
    horafinal.place(x=270, y=300, anchor="center")

    labelmincita = tk.Label(configuracion, text="Minutos por cita: ", font = "Arial 15")
    labelmincita.place(x=142, y=350, anchor="center")
    mincita = tk.Entry(configuracion, font = "Arial 15")
    mincita.place(x=330, y=350, anchor="center")

    labelmaxreinspeccion = tk.Label(configuracion, text="Maximo de dias para reinspeccion: ", font = "Arial 15")
    labelmaxreinspeccion.place(x=220, y=400, anchor="center")
    maxreinspeccion = tk.Entry(configuracion, font = "Arial 15")
    maxreinspeccion.place(x=485, y=400, anchor="center")

    labelmaxfallasgraves = tk.Label(configuracion, text="Maximo de fallas graves: ", font = "Arial 15")
    labelmaxfallasgraves.place(x=180, y=450, anchor="center")
    maxfallasgraves = tk.Entry(configuracion, font = "Arial 15")
    maxfallasgraves.place(x=400, y=450, anchor="center")

    labelmesesauto = tk.Label(configuracion, text="Meses para citas automaticas: ", font = "Arial 15")
    labelmesesauto.place(x=205, y=500, anchor="center")
    mesesauto = tk.Entry(configuracion, font = "Arial 15")
    mesesauto.place(x=450, y=500, anchor="center")

    labeliva = tk.Label(configuracion, text="IVA: ", font = "Arial 15")
    labeliva.place(x=93, y=550, anchor="center")
    iva = tk.Entry(configuracion, font = "Arial 15")
    iva.place(x=230, y=550, anchor="center")

    tarifario = tk.Frame(configuracion, borderwidth=1, relief="solid", bg = "#DADADA")
    tarifario.place(x=1000, y=300, anchor="center")

    vehiculo = tk.Label(tarifario, text="Vehiculo", font = "Arial 20", bg = "#DADADA")
    vehiculo.grid(row=0,column=0)
    tarifa = tk.Label(tarifario, text="Tarifa", font = "Arial 20", bg = "#DADADA")
    tarifa.grid(row=0,column=2)
    espacio = tk.Label(tarifario, text="       ", font = "Arial 20", bg = "#DADADA")
    espacio.grid(row=0,column=1)
    espacio2 = tk.Label(tarifario, text="    ", font = "Arial 20", bg = "#DADADA")
    espacio2.grid(row=0,column=3)
    v1 = tk.Label(tarifario, text="Automovil o vehiculo de carga \n liviana (Menor o igual a 3500kg)", font = "Arial 12", bg = "#DADADA")
    v1.grid(row=1,column=0)
    v2 = tk.Label(tarifario, text="Automovil o vehiculo de carga \n liviana (Mayor a 3500kg pero menor a 8000kg)", font = "Arial 12", bg = "#DADADA")
    v2.grid(row=3,column=0)
    v3 = tk.Label(tarifario, text="Vehiculo de carga pesada y \n cabezales (Mayor o igual a 8000kg)", font = "Arial 12", bg = "#DADADA")
    v3.grid(row=5,column=0)
    v4 = tk.Label(tarifario, text="Taxi", font = "Arial 12", bg = "#DADADA")
    v4.grid(row=6,column=0)
    v5 = tk.Label(tarifario, text="Autobus, bus, microbus", font = "Arial 12", bg = "#DADADA")
    v5.grid(row=7,column=0)
    v6 = tk.Label(tarifario, text="Motocicleta", font = "Arial 12", bg = "#DADADA")
    v6.grid(row=8,column=0)
    v7 = tk.Label(tarifario, text="Equipo especial de obras", font = "Arial 12", bg = "#DADADA")
    v7.grid(row=9,column=0)
    v8 = tk.Label(tarifario, text="Equipo especial agricola", font = "Arial 12", bg = "#DADADA")
    v8.grid(row=10,column=0)

    t1 = tk.Entry(tarifario, font = "Arial 12")
    t1.grid(row=1,column=2)
    t2 = tk.Entry(tarifario, font = "Arial 12")
    t2.grid(row=3,column=2)
    t3 = tk.Entry(tarifario, font = "Arial 12")
    t3.grid(row=5,column=2)
    t4 = tk.Entry(tarifario, font = "Arial 12")
    t4.grid(row=6,column=2)
    t5 = tk.Entry(tarifario, font = "Arial 12")
    t5.grid(row=7,column=2)
    t6 = tk.Entry(tarifario, font = "Arial 12")
    t6.grid(row=8,column=2)
    t7 = tk.Entry(tarifario, font = "Arial 12")
    t7.grid(row=9,column=2)
    t8 = tk.Entry(tarifario, font = "Arial 12")
    t8.grid(row=10,column=2)
    
    Aceptar = tk.Button(configuracion, text="Guardar", width=8, height=1, font = "Arial 20", bg = "#DADADA", command=guardar)
    Aceptar.place(x=1200,y=540)

    cargar()
    
    def volver():
        menu.deiconify()
        configuracion.destroy()
    Volver = tk.Button(configuracion, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)

    configuracion.mainloop()

def ayuda():
    ruta_actual = os.path.dirname(os.path.abspath(__file__)) + '/manual_de_usuario_reteve.pdf' # ruta del archivo
    ruta_actual = ruta_actual.replace("\\", "/") # reemplazar las diagonales invertidas por diagonales normales
    os.startfile(ruta_actual)  # abrir el archivo con la aplicación predeterminada

def acerca_de():
    #Abre ventana
    acerca_de = tk.Tk()
    acerca_de.title("Proyecto 3 Taller de programacion Daniel Alpizar Batista y Ledvin Leiva Mata")
    acerca_de.geometry("800x625")

    menu.withdraw()

    #Datos del programa
    txt = "Revision Tecnica de Vehiculos \n Proyecto 3 Taller de programacion \n Autores: Daniel ALpizar Batista y Ledvin Leiva Mata \n Version 1 \n Fecha de creacion: 19/06/2023"
    #Label con los datos
    acercade = tk.Label(acerca_de, text=txt, font = "Arial 20", width=40, height=5)
    acercade.place(x=70, y=200)

    titulo = tk.Label(acerca_de, text="Acerca de", font = "Arial 40 bold")
    titulo.place(x=270, y=10)

    def volver():
        menu.deiconify()
        acerca_de.destroy()
    Volver = tk.Button(acerca_de, text="Volver", font="Arial 15",command=volver)
    Volver.place(x=10,y=10)

    acerca_de.mainloop()


def Menu():

    global cola_de_espera, cola_de_revision, citas, cantidad_lineas, hora_inicial, hora_final, maxMinutos_revision, maxDays_reinspeccion, maxCantidad_fallas, meses_autocitas, iva_porcentage, tabla_tarifas

    if os.path.exists('citas.json'):
        cargar_arbol()
    else:
        citas = ArbolBinario()

    if os.path.exists('fallas.json'):
        cargar_fallas()
        
    # Cargar datos de configuracion
    if os.path.exists('config.json'):
        with open("config.json") as file:
                data = json.load(file)
        # Asignar datos
        cantidad_lineas = data["cantidad_lineas"]
        hora_inicial = data["hora_inicial"]
        hora_final = data["hora_final"]
        maxMinutos_revision = data["maxMinutos_revision"]
        maxDays_reinspeccion = data["maxDays_reinspeccion"]
        maxCantidad_fallas = data["maxCantidad_fallas"]
        meses_autocitas = data["meses_autocitas"]
        iva_porcentage = data["iva_porcentage"]
        tabla_tarifas = data["tabla_tarifas"]

    cola_de_espera = [[] for _ in range(int(cantidad_lineas))]
    cola_de_revision = [[None, None, None, None, None] for _ in range(int(cantidad_lineas))]

    # Botones

    Titulo = tk.Label(menu, text="Revision Tecnica de Vehiculos", font = "Arial 50 bold")
    Programar_citas = tk.Button(menu, text="Programar citas", width=20, height=1, font = "Arial 20", bg = "#DADADA",  command = programar_citas)
    Cancelar_citas = tk.Button(menu, text="Cancelar citas", width=20, height=1, font = "Arial 20", bg = "#DADADA", command = cancelar_citas)
    Ingreso = tk.Button(menu, text="Ingreso de vehículos", width=20, height=1, font = "Arial 20", bg = "#DADADA", command = ingreso)
    Tablero = tk.Button(menu, text="Tablero de revisión", width=20, height=1, font = "Arial 20", bg = "#DADADA",command = tablero)
    Lista_fallas = tk.Button(menu, text="Lista de fallas", width=20, height=1, font = "Arial 20", bg = "#DADADA", command = lista_fallas)
    Configuracion = tk.Button(menu, text="Configuración", width=20, height=1, font = "Arial 20", bg = "#DADADA", command = config)
    Ayuda = tk.Button(menu, text="Ayuda", width=20, height=1, font = "Arial 20", bg = "#DADADA", command = ayuda)
    Acerca_de = tk.Button(menu, text="Acerca de", width=20, height=1, font = "Arial 20", bg = "#DADADA", command = acerca_de)
    Salir = tk.Button(menu, text="Salir", width=20, height=1, font = "Arial 20", bg = "#DADADA", command=lambda: menu.destroy())


    # Posicionamiento
    Titulo.place(x=700, y=50, anchor="center")
    Programar_citas.place(x=700, y=150, anchor="center")
    Cancelar_citas.place(x=700, y=220, anchor="center")
    Ingreso.place(x=700, y=290, anchor="center")
    Tablero.place(x=700, y=360, anchor="center")
    Lista_fallas.place(x=700, y=430, anchor="center")
    Configuracion.place(x=700, y=500, anchor="center")
    Ayuda.place(x=700, y=570, anchor="center")
    Acerca_de.place(x=700, y=640, anchor="center")
    Salir.place(x=700, y=710, anchor="center")

    # Iniciar ventana
    menu.mainloop()

# ------------------------------------------------------------------------------------------------------------------------------

# Iniciar programa

Menu()