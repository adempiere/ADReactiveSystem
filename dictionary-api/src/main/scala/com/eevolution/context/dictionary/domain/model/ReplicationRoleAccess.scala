package com.eevolution.context.dictionary.domain.model

import ai.x.play.json.Jsonx
import com.eevolution.context.dictionary.api.{ActiveEnabled, DomainModel, Identifiable, Traceable}
import org.joda.time.DateTime

case class ReplicationRoleAccess(replicationRoleAccessId: Int,
                                 tenantId: Int,
                                 organizationId: Int,
                                 replicationStrategyId: Option[Int],
                                 roleId: Option[Int],
                                 created : DateTime = DateTime.now,
                                 createdBy : Int ,
                                 isActive : Boolean = true,
                                 isReadOnly: Option[Boolean],
                                 updated : DateTime = DateTime.now,
                                 updatedBy : Int,
                                 uuid: String
                                ) extends DomainModel

  with ActiveEnabled
  with Identifiable
  with Traceable {
  override type ActiveEnabled = this.type
  override type Identifiable = this.type
  override type Traceable = this.type

  override def Id: Int = replicationRoleAccessId

  override val entityName: String = "AD_ReplicationRoleAccess"
  override val identifier: String = "AD_ReplicationRoleAccess_ID"
}

object ReplicationRoleAccess  {
  implicit lazy val jsonFormat = Jsonx.formatCaseClass[ReplicationRoleAccess]
  def create(replicationRoleAccessId: Int,
             tenantId: Int,
             organizationId: Int,
             replicationStrategyId: Int,
             roleId: Int,
             created : DateTime,
             createdBy : Int ,
             isActive : Boolean,
             isReadOnly: Boolean,
             updated : DateTime,
             updatedBy : Int,
             uuid: String) = ReplicationRoleAccess(replicationRoleAccessId, tenantId, organizationId,
    None, None, created, createdBy, isActive, None, updated, updatedBy, uuid)
}



