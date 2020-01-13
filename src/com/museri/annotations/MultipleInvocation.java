package com.museri.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 

/*
 * En Java, una anotaci�n se define por medio de la palabra reservada @interface. 
 * Hay que tener ciertas consideraciones en cuenta a la hora de crearlas:

Cada m�todo dentro de la anotaci�n es un elemento.
Los m�todos no deben tener par�metros o cl�usulas throws.
Los tipos de retorno est�n restringidos a tipos primitivos, String, Class, enum, anotaciones, y arrrays de los tipos anteriores.
Los m�todos pueden tener valores por defecto
Vamos a crear una anotaci�n que indique cu�ntas veces debe ejecutarse cada elemento que se anote con ella:
 * 
 * 
 * Como se ve en el c�digo, hemos usado algunas meta-anotaciones para definir ciertos par�metors en nuestra anotaci�n. Veamos cu�les de estas se pueden usar al crear nuestras anotaciones y qu� significan:

@Target � Especifica el tipo de elemento al que se va a asociar la anotaci�n.
ElementType.TYPE � se puede aplicar a cualquier elemento de la clase.
ElementType.FIELD � se puede aplicar a un miebro de la clase.
ElementType.METHOD � se puede aplicar a un m�todo
ElementType.PARAMETER � se puede aplicar a par�metros de un m�todo.
ElementType.CONSTRUCTOR � se puede aplicar a constructores
ElementType.LOCAL_VARIABLE � se puede aplicar a variables locales
ElementType.ANNOTATION_TYPE � indica que el tipo declarado en s� es un tipo de anotaci�n.
@Retention � Especifica el nivel de retenci�n de la anotaci�n (cu�ndo se puede acceder a ella).
RetentionPolicy.SOURCE � Retenida s�lo a nivel de c�digo; ignorada por el compilador.
RetentionPolicy.CLASS � Retenida en tiempo de compilaci�n, pero ignorada en tiempo de ejcuci�n.
RetentionPolicy.RUNTIME � Retenida en tiempo de ejecuci�n, s�lo se puede acceder a ella en este tiempo.
@Documented � Har� que la anotaci�n se mencione en el javadoc.
@Inherited � Indica que la anotaci�n ser� heredada autom�ticamente.
En nuestro caso hemos dicho que sea en tiempo de ejecuci�n y que se aplique a m�todos. Tambi�n le hemos a�adido un valor por defecto con la palabra default*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MultipleInvocation {
 
    int timesToInvoke() default 1;
}