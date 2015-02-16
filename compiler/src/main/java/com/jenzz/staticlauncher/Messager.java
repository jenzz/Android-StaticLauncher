package com.jenzz.staticlauncher;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.NOTE;
import static javax.tools.Diagnostic.Kind.WARNING;

/**
 * Created by jenzz on 16/02/15.
 */
final class Messager {

  private javax.annotation.processing.Messager messager;

  void init(ProcessingEnvironment processingEnvironment) {
    messager = processingEnvironment.getMessager();
  }

  void note(Element e, String msg, Object... args) {
    checkInitialized();
    messager.printMessage(NOTE, String.format(msg, args), e);
  }

  void warn(Element e, String msg, Object... args) {
    checkInitialized();
    messager.printMessage(WARNING, String.format(msg, args), e);
  }

  void error(Element e, String msg, Object... args) {
    checkInitialized();
    messager.printMessage(ERROR, String.format(msg, args), e);
  }

  private void checkInitialized() {
    if (messager == null) {
      throw new IllegalStateException("Messager not ready. Have you called init()?");
    }
  }
}
