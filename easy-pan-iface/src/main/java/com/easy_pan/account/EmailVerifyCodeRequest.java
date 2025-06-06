/**
 * Autogenerated by Thrift Compiler (0.20.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.easy_pan.account;

import jakarta.annotation.Generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@Generated(value = "Autogenerated by Thrift Compiler (0.20.0)", date = "2025-06-02")
public class EmailVerifyCodeRequest implements org.apache.thrift.TBase<EmailVerifyCodeRequest, EmailVerifyCodeRequest._Fields>, java.io.Serializable, Cloneable, Comparable<EmailVerifyCodeRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EmailVerifyCodeRequest");

  private static final org.apache.thrift.protocol.TField EMAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("email", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CHECK_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("checkCode", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField EMAIL_VERIFY_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("emailVerifyType", org.apache.thrift.protocol.TType.BYTE, (short)3);
  private static final org.apache.thrift.protocol.TField BASE_FIELD_DESC = new org.apache.thrift.protocol.TField("base", org.apache.thrift.protocol.TType.STRUCT, (short)255);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new EmailVerifyCodeRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new EmailVerifyCodeRequestTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String email; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String checkCode; // required
  public byte emailVerifyType; // required
  public @org.apache.thrift.annotation.Nullable com.cutejiuge.base.Base base; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EMAIL((short)1, "email"),
    CHECK_CODE((short)2, "checkCode"),
    EMAIL_VERIFY_TYPE((short)3, "emailVerifyType"),
    BASE((short)255, "base");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // EMAIL
          return EMAIL;
        case 2: // CHECK_CODE
          return CHECK_CODE;
        case 3: // EMAIL_VERIFY_TYPE
          return EMAIL_VERIFY_TYPE;
        case 255: // BASE
          return BASE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __EMAILVERIFYTYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.BASE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EMAIL, new org.apache.thrift.meta_data.FieldMetaData("email", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHECK_CODE, new org.apache.thrift.meta_data.FieldMetaData("checkCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EMAIL_VERIFY_TYPE, new org.apache.thrift.meta_data.FieldMetaData("emailVerifyType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.BASE, new org.apache.thrift.meta_data.FieldMetaData("base", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.cutejiuge.base.Base.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EmailVerifyCodeRequest.class, metaDataMap);
  }

  public EmailVerifyCodeRequest() {
  }

  public EmailVerifyCodeRequest(
    java.lang.String email,
    java.lang.String checkCode,
    byte emailVerifyType)
  {
    this();
    this.email = email;
    this.checkCode = checkCode;
    this.emailVerifyType = emailVerifyType;
    setEmailVerifyTypeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EmailVerifyCodeRequest(EmailVerifyCodeRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetEmail()) {
      this.email = other.email;
    }
    if (other.isSetCheckCode()) {
      this.checkCode = other.checkCode;
    }
    this.emailVerifyType = other.emailVerifyType;
    if (other.isSetBase()) {
      this.base = new com.cutejiuge.base.Base(other.base);
    }
  }

  @Override
  public EmailVerifyCodeRequest deepCopy() {
    return new EmailVerifyCodeRequest(this);
  }

  @Override
  public void clear() {
    this.email = null;
    this.checkCode = null;
    setEmailVerifyTypeIsSet(false);
    this.emailVerifyType = 0;
    this.base = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEmail() {
    return this.email;
  }

  public EmailVerifyCodeRequest setEmail(@org.apache.thrift.annotation.Nullable java.lang.String email) {
    this.email = email;
    return this;
  }

  public void unsetEmail() {
    this.email = null;
  }

  /** Returns true if field email is set (has been assigned a value) and false otherwise */
  public boolean isSetEmail() {
    return this.email != null;
  }

  public void setEmailIsSet(boolean value) {
    if (!value) {
      this.email = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCheckCode() {
    return this.checkCode;
  }

  public EmailVerifyCodeRequest setCheckCode(@org.apache.thrift.annotation.Nullable java.lang.String checkCode) {
    this.checkCode = checkCode;
    return this;
  }

  public void unsetCheckCode() {
    this.checkCode = null;
  }

  /** Returns true if field checkCode is set (has been assigned a value) and false otherwise */
  public boolean isSetCheckCode() {
    return this.checkCode != null;
  }

  public void setCheckCodeIsSet(boolean value) {
    if (!value) {
      this.checkCode = null;
    }
  }

  public byte getEmailVerifyType() {
    return this.emailVerifyType;
  }

  public EmailVerifyCodeRequest setEmailVerifyType(byte emailVerifyType) {
    this.emailVerifyType = emailVerifyType;
    setEmailVerifyTypeIsSet(true);
    return this;
  }

  public void unsetEmailVerifyType() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __EMAILVERIFYTYPE_ISSET_ID);
  }

  /** Returns true if field emailVerifyType is set (has been assigned a value) and false otherwise */
  public boolean isSetEmailVerifyType() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __EMAILVERIFYTYPE_ISSET_ID);
  }

  public void setEmailVerifyTypeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __EMAILVERIFYTYPE_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public com.cutejiuge.base.Base getBase() {
    return this.base;
  }

  public EmailVerifyCodeRequest setBase(@org.apache.thrift.annotation.Nullable com.cutejiuge.base.Base base) {
    this.base = base;
    return this;
  }

  public void unsetBase() {
    this.base = null;
  }

  /** Returns true if field base is set (has been assigned a value) and false otherwise */
  public boolean isSetBase() {
    return this.base != null;
  }

  public void setBaseIsSet(boolean value) {
    if (!value) {
      this.base = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case EMAIL:
      if (value == null) {
        unsetEmail();
      } else {
        setEmail((java.lang.String)value);
      }
      break;

    case CHECK_CODE:
      if (value == null) {
        unsetCheckCode();
      } else {
        setCheckCode((java.lang.String)value);
      }
      break;

    case EMAIL_VERIFY_TYPE:
      if (value == null) {
        unsetEmailVerifyType();
      } else {
        setEmailVerifyType((java.lang.Byte)value);
      }
      break;

    case BASE:
      if (value == null) {
        unsetBase();
      } else {
        setBase((com.cutejiuge.base.Base)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case EMAIL:
      return getEmail();

    case CHECK_CODE:
      return getCheckCode();

    case EMAIL_VERIFY_TYPE:
      return getEmailVerifyType();

    case BASE:
      return getBase();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case EMAIL:
      return isSetEmail();
    case CHECK_CODE:
      return isSetCheckCode();
    case EMAIL_VERIFY_TYPE:
      return isSetEmailVerifyType();
    case BASE:
      return isSetBase();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof EmailVerifyCodeRequest)
      return this.equals((EmailVerifyCodeRequest)that);
    return false;
  }

  public boolean equals(EmailVerifyCodeRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_email = true && this.isSetEmail();
    boolean that_present_email = true && that.isSetEmail();
    if (this_present_email || that_present_email) {
      if (!(this_present_email && that_present_email))
        return false;
      if (!this.email.equals(that.email))
        return false;
    }

    boolean this_present_checkCode = true && this.isSetCheckCode();
    boolean that_present_checkCode = true && that.isSetCheckCode();
    if (this_present_checkCode || that_present_checkCode) {
      if (!(this_present_checkCode && that_present_checkCode))
        return false;
      if (!this.checkCode.equals(that.checkCode))
        return false;
    }

    boolean this_present_emailVerifyType = true;
    boolean that_present_emailVerifyType = true;
    if (this_present_emailVerifyType || that_present_emailVerifyType) {
      if (!(this_present_emailVerifyType && that_present_emailVerifyType))
        return false;
      if (this.emailVerifyType != that.emailVerifyType)
        return false;
    }

    boolean this_present_base = true && this.isSetBase();
    boolean that_present_base = true && that.isSetBase();
    if (this_present_base || that_present_base) {
      if (!(this_present_base && that_present_base))
        return false;
      if (!this.base.equals(that.base))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEmail()) ? 131071 : 524287);
    if (isSetEmail())
      hashCode = hashCode * 8191 + email.hashCode();

    hashCode = hashCode * 8191 + ((isSetCheckCode()) ? 131071 : 524287);
    if (isSetCheckCode())
      hashCode = hashCode * 8191 + checkCode.hashCode();

    hashCode = hashCode * 8191 + (int) (emailVerifyType);

    hashCode = hashCode * 8191 + ((isSetBase()) ? 131071 : 524287);
    if (isSetBase())
      hashCode = hashCode * 8191 + base.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(EmailVerifyCodeRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetEmail(), other.isSetEmail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.email, other.email);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCheckCode(), other.isSetCheckCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheckCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.checkCode, other.checkCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEmailVerifyType(), other.isSetEmailVerifyType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmailVerifyType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.emailVerifyType, other.emailVerifyType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetBase(), other.isSetBase());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBase()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.base, other.base);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("EmailVerifyCodeRequest(");
    boolean first = true;

    sb.append("email:");
    if (this.email == null) {
      sb.append("null");
    } else {
      sb.append(this.email);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("checkCode:");
    if (this.checkCode == null) {
      sb.append("null");
    } else {
      sb.append(this.checkCode);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("emailVerifyType:");
    sb.append(this.emailVerifyType);
    first = false;
    if (isSetBase()) {
      if (!first) sb.append(", ");
      sb.append("base:");
      if (this.base == null) {
        sb.append("null");
      } else {
        sb.append(this.base);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (base != null) {
      base.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class EmailVerifyCodeRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public EmailVerifyCodeRequestStandardScheme getScheme() {
      return new EmailVerifyCodeRequestStandardScheme();
    }
  }

  private static class EmailVerifyCodeRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<EmailVerifyCodeRequest> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, EmailVerifyCodeRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EMAIL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.email = iprot.readString();
              struct.setEmailIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CHECK_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.checkCode = iprot.readString();
              struct.setCheckCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EMAIL_VERIFY_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.emailVerifyType = iprot.readByte();
              struct.setEmailVerifyTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 255: // BASE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.base = new com.cutejiuge.base.Base();
              struct.base.read(iprot);
              struct.setBaseIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, EmailVerifyCodeRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.email != null) {
        oprot.writeFieldBegin(EMAIL_FIELD_DESC);
        oprot.writeString(struct.email);
        oprot.writeFieldEnd();
      }
      if (struct.checkCode != null) {
        oprot.writeFieldBegin(CHECK_CODE_FIELD_DESC);
        oprot.writeString(struct.checkCode);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(EMAIL_VERIFY_TYPE_FIELD_DESC);
      oprot.writeByte(struct.emailVerifyType);
      oprot.writeFieldEnd();
      if (struct.base != null) {
        if (struct.isSetBase()) {
          oprot.writeFieldBegin(BASE_FIELD_DESC);
          struct.base.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EmailVerifyCodeRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public EmailVerifyCodeRequestTupleScheme getScheme() {
      return new EmailVerifyCodeRequestTupleScheme();
    }
  }

  private static class EmailVerifyCodeRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<EmailVerifyCodeRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EmailVerifyCodeRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetEmail()) {
        optionals.set(0);
      }
      if (struct.isSetCheckCode()) {
        optionals.set(1);
      }
      if (struct.isSetEmailVerifyType()) {
        optionals.set(2);
      }
      if (struct.isSetBase()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetEmail()) {
        oprot.writeString(struct.email);
      }
      if (struct.isSetCheckCode()) {
        oprot.writeString(struct.checkCode);
      }
      if (struct.isSetEmailVerifyType()) {
        oprot.writeByte(struct.emailVerifyType);
      }
      if (struct.isSetBase()) {
        struct.base.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EmailVerifyCodeRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.email = iprot.readString();
        struct.setEmailIsSet(true);
      }
      if (incoming.get(1)) {
        struct.checkCode = iprot.readString();
        struct.setCheckCodeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.emailVerifyType = iprot.readByte();
        struct.setEmailVerifyTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.base = new com.cutejiuge.base.Base();
        struct.base.read(iprot);
        struct.setBaseIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

