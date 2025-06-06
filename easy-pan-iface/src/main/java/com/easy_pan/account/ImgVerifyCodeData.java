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
public class ImgVerifyCodeData implements org.apache.thrift.TBase<ImgVerifyCodeData, ImgVerifyCodeData._Fields>, java.io.Serializable, Cloneable, Comparable<ImgVerifyCodeData> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ImgVerifyCodeData");

  private static final org.apache.thrift.protocol.TField IMG_FIELD_DESC = new org.apache.thrift.protocol.TField("img", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("code", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ImgVerifyCodeDataStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ImgVerifyCodeDataTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer img; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String code; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    IMG((short)1, "img"),
    CODE((short)2, "code");

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
        case 1: // IMG
          return IMG;
        case 2: // CODE
          return CODE;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IMG, new org.apache.thrift.meta_data.FieldMetaData("img", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.CODE, new org.apache.thrift.meta_data.FieldMetaData("code", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ImgVerifyCodeData.class, metaDataMap);
  }

  public ImgVerifyCodeData() {
  }

  public ImgVerifyCodeData(
    java.nio.ByteBuffer img,
    java.lang.String code)
  {
    this();
    this.img = org.apache.thrift.TBaseHelper.copyBinary(img);
    this.code = code;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ImgVerifyCodeData(ImgVerifyCodeData other) {
    if (other.isSetImg()) {
      this.img = org.apache.thrift.TBaseHelper.copyBinary(other.img);
    }
    if (other.isSetCode()) {
      this.code = other.code;
    }
  }

  @Override
  public ImgVerifyCodeData deepCopy() {
    return new ImgVerifyCodeData(this);
  }

  @Override
  public void clear() {
    this.img = null;
    this.code = null;
  }

  public byte[] getImg() {
    setImg(org.apache.thrift.TBaseHelper.rightSize(img));
    return img == null ? null : img.array();
  }

  public java.nio.ByteBuffer bufferForImg() {
    return org.apache.thrift.TBaseHelper.copyBinary(img);
  }

  public ImgVerifyCodeData setImg(byte[] img) {
    this.img = img == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(img.clone());
    return this;
  }

  public ImgVerifyCodeData setImg(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer img) {
    this.img = org.apache.thrift.TBaseHelper.copyBinary(img);
    return this;
  }

  public void unsetImg() {
    this.img = null;
  }

  /** Returns true if field img is set (has been assigned a value) and false otherwise */
  public boolean isSetImg() {
    return this.img != null;
  }

  public void setImgIsSet(boolean value) {
    if (!value) {
      this.img = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCode() {
    return this.code;
  }

  public ImgVerifyCodeData setCode(@org.apache.thrift.annotation.Nullable java.lang.String code) {
    this.code = code;
    return this;
  }

  public void unsetCode() {
    this.code = null;
  }

  /** Returns true if field code is set (has been assigned a value) and false otherwise */
  public boolean isSetCode() {
    return this.code != null;
  }

  public void setCodeIsSet(boolean value) {
    if (!value) {
      this.code = null;
    }
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case IMG:
      if (value == null) {
        unsetImg();
      } else {
        if (value instanceof byte[]) {
          setImg((byte[])value);
        } else {
          setImg((java.nio.ByteBuffer)value);
        }
      }
      break;

    case CODE:
      if (value == null) {
        unsetCode();
      } else {
        setCode((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case IMG:
      return getImg();

    case CODE:
      return getCode();

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
    case IMG:
      return isSetImg();
    case CODE:
      return isSetCode();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof ImgVerifyCodeData)
      return this.equals((ImgVerifyCodeData)that);
    return false;
  }

  public boolean equals(ImgVerifyCodeData that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_img = true && this.isSetImg();
    boolean that_present_img = true && that.isSetImg();
    if (this_present_img || that_present_img) {
      if (!(this_present_img && that_present_img))
        return false;
      if (!this.img.equals(that.img))
        return false;
    }

    boolean this_present_code = true && this.isSetCode();
    boolean that_present_code = true && that.isSetCode();
    if (this_present_code || that_present_code) {
      if (!(this_present_code && that_present_code))
        return false;
      if (!this.code.equals(that.code))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetImg()) ? 131071 : 524287);
    if (isSetImg())
      hashCode = hashCode * 8191 + img.hashCode();

    hashCode = hashCode * 8191 + ((isSetCode()) ? 131071 : 524287);
    if (isSetCode())
      hashCode = hashCode * 8191 + code.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ImgVerifyCodeData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetImg(), other.isSetImg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.img, other.img);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCode(), other.isSetCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.code, other.code);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ImgVerifyCodeData(");
    boolean first = true;

    sb.append("img:");
    if (this.img == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.img, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("code:");
    if (this.code == null) {
      sb.append("null");
    } else {
      sb.append(this.code);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ImgVerifyCodeDataStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public ImgVerifyCodeDataStandardScheme getScheme() {
      return new ImgVerifyCodeDataStandardScheme();
    }
  }

  private static class ImgVerifyCodeDataStandardScheme extends org.apache.thrift.scheme.StandardScheme<ImgVerifyCodeData> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, ImgVerifyCodeData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // IMG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.img = iprot.readBinary();
              struct.setImgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.code = iprot.readString();
              struct.setCodeIsSet(true);
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
    public void write(org.apache.thrift.protocol.TProtocol oprot, ImgVerifyCodeData struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.img != null) {
        oprot.writeFieldBegin(IMG_FIELD_DESC);
        oprot.writeBinary(struct.img);
        oprot.writeFieldEnd();
      }
      if (struct.code != null) {
        oprot.writeFieldBegin(CODE_FIELD_DESC);
        oprot.writeString(struct.code);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ImgVerifyCodeDataTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public ImgVerifyCodeDataTupleScheme getScheme() {
      return new ImgVerifyCodeDataTupleScheme();
    }
  }

  private static class ImgVerifyCodeDataTupleScheme extends org.apache.thrift.scheme.TupleScheme<ImgVerifyCodeData> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ImgVerifyCodeData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetImg()) {
        optionals.set(0);
      }
      if (struct.isSetCode()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetImg()) {
        oprot.writeBinary(struct.img);
      }
      if (struct.isSetCode()) {
        oprot.writeString(struct.code);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ImgVerifyCodeData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.img = iprot.readBinary();
        struct.setImgIsSet(true);
      }
      if (incoming.get(1)) {
        struct.code = iprot.readString();
        struct.setCodeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

