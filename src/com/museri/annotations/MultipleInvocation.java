package com.museri.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 

/*
 * En Java, una anotación se define por medio de la palabra reservada @interface. 
 * Hay que tener ciertas consideraciones en cuenta a la hora de crearlas:

Cada método dentro de la anotación es un elemento.
Los métodos no deben tener parámetros o cláusulas throws.
Los tipos de retorno están restringidos a tipos primitivos, String, Class, enum, anotaciones, y arrrays de los tipos anteriores.
Los métodos pueden tener valores por defecto
Vamos a crear una anotación que indique cuántas veces debe ejecutarse cada elemento que se anote con ella:
 * 
 * 
 * Como se ve en el código, hemos usado algunas meta-anotaciones para definir ciertos parámetors en nuestra anotación. Veamos cuáles de estas se pueden usar al crear nuestras anotaciones y qué significan:

@Target – Especifica el tipo de elemento al que se va a asociar la anotación.
ElementType.TYPE – se puede aplicar a cualquier elemento de la clase.
ElementType.FIELD – se puede aplicar a un miebro de la clase.
ElementType.METHOD – se puede aplicar a un método
ElementType.PARAMETER – se puede aplicar a parámetros de un método.
ElementType.CONSTRUCTOR – se puede aplicar a constructores
ElementType.LOCAL_VARIABLE – se puede aplicar a variables locales
ElementType.ANNOTATION_TYPE – indica que el tipo declarado en sí es un tipo de anotación.
@Retention – Especifica el nivel de retención de la anotación (cuándo se puede acceder a ella).
RetentionPolicy.SOURCE — Retenida sólo a nivel de código; ignorada por el compilador.
RetentionPolicy.CLASS — Retenida en tiempo de compilación, pero ignorada en tiempo de ejcución.
RetentionPolicy.RUNTIME — Retenida en tiempo de ejecución, sólo se puede acceder a ella en este tiempo.
@Documented – Hará que la anotación se mencione en el javadoc.
@Inherited – Indica que la anotación será heredada automáticamente.
En nuestro caso hemos dicho que sea en tiempo de ejecución y que se aplique a métodos. También le hemos añadido un valor por defecto con la palabra default*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MultipleInvocation {
 
    int timesToInvoke() default 1;
}