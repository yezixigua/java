/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\Administrator\\workspace\\07_Ã‘±¶\\src\\com\\m520it\\alipay\\IAlipayService.aidl
 */
package com.m520it.alipay;
public interface IAlipayService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.m520it.alipay.IAlipayService
{
private static final java.lang.String DESCRIPTOR = "com.m520it.alipay.IAlipayService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.m520it.alipay.IAlipayService interface,
 * generating a proxy if needed.
 */
public static com.m520it.alipay.IAlipayService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.m520it.alipay.IAlipayService))) {
return ((com.m520it.alipay.IAlipayService)iin);
}
return new com.m520it.alipay.IAlipayService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_callSafePay:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
double _arg3;
_arg3 = data.readDouble();
long _arg4;
_arg4 = data.readLong();
int _result = this.callSafePay(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.m520it.alipay.IAlipayService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int callSafePay(java.lang.String account, java.lang.String pwd, java.lang.String payPwd, double money, long currTimeMiles) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(account);
_data.writeString(pwd);
_data.writeString(payPwd);
_data.writeDouble(money);
_data.writeLong(currTimeMiles);
mRemote.transact(Stub.TRANSACTION_callSafePay, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_callSafePay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public int callSafePay(java.lang.String account, java.lang.String pwd, java.lang.String payPwd, double money, long currTimeMiles) throws android.os.RemoteException;
}
