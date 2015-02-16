package com.jenzz.staticlauncher;

import java.util.Set;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * Created by jenzz on 16/02/15.
 */
final class ClassValidator {

  private final TypeElement annotatedClass;
  private final Set<Modifier> modifiers;

  ClassValidator(TypeElement annotatedClass) {
    this.annotatedClass = annotatedClass;
    this.modifiers = annotatedClass.getModifiers();
  }

  boolean isPublic() {
    return modifiers.contains(PUBLIC);
  }

  boolean isAbstract() {
    return modifiers.contains(ABSTRACT);
  }
}
