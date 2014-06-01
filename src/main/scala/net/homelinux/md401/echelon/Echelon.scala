package net.homelinux.md401.echelon

import shapeless._
import scala.None

trait ColumnExtension[MT] {
  type Extended <: HList
}

object ColumnExtension {
  implicit object EmptyColumnExtension extends ColumnExtension[HNil] {
    type Extended = HNil
  }
  
  implicit def AddRowColumnExtension[RT <: HList, TT <: HList, ETT <: HList] = new ColumnExtension[RT :: TT] {
    //TODO: replace Int with some kind of zero type
    type Extended = (Int :: RT) :: ETT
  }
}

trait IsReducedEchelonForm[MT]

object IsReducedEchelonForm {
  implicit object EmptyIsReducedEchelonForm extends IsReducedEchelonForm[HNil]

  //TODO: replace the int with a new row
  implicit def AddRowReducedEchelonForm[TT <: HNil](implicit tiref: IsReducedEchelonForm[TT], ce: ColumnExtension[TT]) = new IsReducedEchelonForm[Int :: ce.Extended] {}
}

object Echelon {

  def solve[MT <: HList](matrix: MT)(implicit w: IsReducedEchelonForm[MT]) = matrix
}