package com.ltp.gradesubmission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {

  // boiler plate code you meed to include when defining custom constraints
  String message() default "Invalid Data";
	Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
