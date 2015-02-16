package com.jenzz.staticlauncher;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import javax.lang.model.element.TypeElement;

import static com.squareup.javapoet.ClassName.get;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

/**
 * Created by jenzz on 16/02/15.
 */
final class CodeGenerator {

  private static final String CLASS_SUFFIX = "Launcher";

  private final String annotatedClassName;
  private final String generatedClassName;

  CodeGenerator(TypeElement annotatedClass) {
    this.annotatedClassName = annotatedClass.getSimpleName().toString();
    this.generatedClassName = annotatedClassName + CLASS_SUFFIX;
  }

  TypeSpec generateClass() {
    return classBuilder(generatedClassName)
        .addModifiers(PUBLIC, FINAL)
        .addMethod(getIntent())
        .addMethod(startActivity())
        .build();
  }

  private MethodSpec getIntent() {
    ClassName intentClass = get("android.content", "Intent");
    return methodBuilder("getIntent")
        .addModifiers(PUBLIC, STATIC)
        .addParameter(get("android.content", "Context"), "context")
        .addStatement("return new $T(context, $L.class)", intentClass, annotatedClassName)
        .returns(intentClass)
        .build();
  }

  private MethodSpec startActivity() {
    return methodBuilder("startActivity")
        .addModifiers(PUBLIC, STATIC)
        .addParameter(get("android.content", "Context"), "context")
        .addStatement("context.startActivity(getIntent(context))")
        .build();
  }
}
