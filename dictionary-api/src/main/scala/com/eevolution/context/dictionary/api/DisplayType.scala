package com.eevolution.context.dictionary.api
  /**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  * You should have received a copy of the GNU Affero General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  */

/**
  * Define Static Type for Application Dictionary
  */
object DisplayType {

  /** Display Type 10	String	*/
  val  String : Int  =  10
  /** Display Type 11	Integer	*/
  val  Integer: Int  =  11
  /** Display Type 12	Amount	*/
  val  Amount : Int  =  12
  /** Display Type 13	ID	*/
  val  ID     : Int  =  13
  /** Display Type 14	Text	*/
  val  Text   : Int  =  14
  /** Display Type 15	Date	*/
  val  Date   : Int  =  15
  /** Display Type 16	DateTime	*/
  val  DateTime  : Int =  16
  /** Display Type 17	List	*/
  val  List   : Int  =  17
  /** Display Type 18	Table	*/
  val  Table  : Int  =  18
  /** Display Type 19	TableDir	*/
  val  TableDir  : Int =  19
  /** Display Type 20	YN	*/
  val  YesNo  : Int  =  20
  /** Display Type 21	Location	*/
  val  Location  : Int =  21
  /** Display Type 22	Number	*/
  val  Number : Int  =  22
  /** Display Type 23	BLOB	*/
  val  Binary : Int  =  23
  /** Display Type 24	Time	*/
  val  Time   : Int  =  24
  /** Display Type 25	Account	*/
  val  Account: Int  =  25
  /** Display Type 26	RowID	*/
  val  RowID  : Int  =  26
  /** Display Type 27	Color   */
  val  Color  : Int  =  27
  /** Display Type 28	Button	*/
  val  Button	  : Int =  28
  /** Display Type 29	Quantity	*/
  val  Quantity  : Int =  29
  /** Display Type 30	Search	*/
  val  Search : Int  =  30
  /** Display Type 31	Locator	*/
  val  Locator: Int  =  31
  /** Display Type 32 Image	*/
  val  Image  : Int  =  32
  /** Display Type 33 Assignment	*/
  val  Assignment: Int =  33
  /** Display Type 34	Memo	*/
  val  Memo   : Int  =  34
  /** Display Type 35	PAttribute	*/
  val  PAttribute: Int =  35
  /** Display Type 36	CLOB	*/
  val  TextLong  : Int =  36
  /** Display Type 37	CostPrice	*/
  val  CostPrice : Int =  37
  /** Display Type 38	File Path	*/
  val  FilePath : Int =  38
  /** Display Type 39 File Name	*/
  val  FileName : Int =  39
  /** Display Type 40	URL	*/
  val  URL : Int =  40
  /** Display Type 42	PrinterName	*/
  val  PrinterName : Int =  42
  /** Display Type 53370 Chart */
  val  Chart: Int =  53370

  def geClass(reference : Int , yesNoAsBoolean : Boolean) : String =
  {
    if ( isText(reference) ||   reference == List) "String"
    else if (isId(reference) || reference == Integer) "String"
    else if (isNumeric(reference)) "BigDecimal"
    else if (isDate(reference)) "DateTime"
    else if (reference == YesNo ) if (yesNoAsBoolean) "Boolean" else "String"
    else if (reference == Button) "String"
    else if (isLob(reference)) "Byte"
    else "AnyRef"
  }

  def isText(reference: Int): Boolean = reference match {
    case String => true
    case Text => true
    case TextLong => true
    case Memo => true
    case FilePath => true
    case FileName => true
    case URL => true
    case PrinterName => true
    case _ => false
  }

  def isDate(reference: Int): Boolean = reference match {
    case Date => true
    case DateTime => true
    case _ => false
  }

  def isLookup(reference: Int): Boolean = reference match {
    case List => true
    case Table => true
    case TableDir => true
    case Search => true
    case _ => false
  }

  def isLob(reference: Int): Boolean = reference match {
    case Binary => true
    case TextLong => true
    case _ => false
  }

  def isNumeric(reference: Int): Boolean = reference match {
    case Amount => true
    case Number => true
    case CostPrice => true
    case Integer => true
    case Quantity => true
    case _ => false
  }

  def isId(reference: Int): Boolean = reference match {
    case ID => true
    case Table => true
    case TableDir => true
    case Search => true
    case Location => true
    case Locator => true
    case Account => true
    case Assignment => true
    case PAttribute => true
    case Image => true
    case Color => true
    case _ => false
  }

}
