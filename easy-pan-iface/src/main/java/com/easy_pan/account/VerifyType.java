/**
 * Autogenerated by Thrift Compiler (0.20.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.easy_pan.account;


import jakarta.annotation.Generated;

@Generated(value = "Autogenerated by Thrift Compiler (0.20.0)", date = "2025-06-02")
public enum VerifyType implements org.apache.thrift.TEnum {
  LoginAndRegister(0),
  EmailVerification(1);

  private final int value;

  private VerifyType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static VerifyType findByValue(int value) { 
    switch (value) {
      case 0:
        return LoginAndRegister;
      case 1:
        return EmailVerification;
      default:
        return null;
    }
  }
}
