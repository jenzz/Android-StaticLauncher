package com.jenzz.staticlauncher;

import javax.lang.model.element.TypeElement;

/**
 * Created by jenzz on 16/02/15.
 */
class UnnamedPackageException extends Exception {

  public UnnamedPackageException(TypeElement typeElement) {
    super("The package of " + typeElement.getSimpleName() + " is unnamed");
  }
}
