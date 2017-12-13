package com.eevolution.context.dictionary.application

import com.eevolution.context.dictionary.infrastructure.repository._
import com.eevolution.context.dictionary.infrastructure.service._
import com.eevolution.context.dictionary.infrastructure.service.impl._
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcPersistenceComponents
import com.lightbend.lagom.scaladsl.server.{LagomServer, LagomServerComponents, _}
import com.softwaremill.macwire._
import play.api.Environment
import play.api.db.HikariCPComponents
import play.api.libs.ws.ahc.AhcWSComponents

import scala.concurrent.ExecutionContext

/**
  * Copyright (C) 2003-2017, e-Evolution Consultants S.A. , http://www.e-evolution.com
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  * Email: victor.perez@e-evolution.com, http://www.e-evolution.com , http://github.com/e-Evolution
  * Created by victor.perez@e-evolution.com , www.e-evolution.com
  * Email: emeris.hernandez@e-evolution.com, http://www.e-evolution.com , http://github.com/EmerisScala
  * Modified by emeris.hernandez@e-evolution.com , www.e-evolution.com on 13/12/2017.
  */

/**
  * Entity Component
  */
trait DictionaryComponents extends LagomServerComponents
  with JdbcPersistenceComponents
  with HikariCPComponents {

  implicit def executionContext: ExecutionContext
  def environment: Environment

  override lazy val lagomServer = LagomServer.forServices(
    bindService[AccessLogService].to(wire[AccessLogServiceImpl]),
    bindService[AlertService].to(wire[AlertServiceImpl]),
    bindService[AlertProcessorService].to(wire[AlertProcessorServiceImpl]),
    bindService[AlertProcessorLogService].to(wire[AlertProcessorLogServiceImpl]),
    bindService[AlertRecipientService].to(wire[AlertRecipientServiceImpl]),
    bindService[AlertRuleService].to(wire[AlertRuleServiceImpl]),
    bindService[ArchiveService].to(wire[ArchiveServiceImpl]),
    bindService[AttachmentService].to(wire[AttachmentServiceImpl]),
    bindService[AttachmentNoteService].to(wire[AttachmentNoteServiceImpl]),
    bindService[AttributeService].to(wire[AttributeServiceImpl]),
    bindService[AttributeAccessService].to(wire[AttributeAccessServiceImpl]),
    bindService[AttributeExtendService].to(wire[AttributeExtendServiceImpl]),
    bindService[AttributeProcessService].to(wire[AttributeProcessServiceImpl]),
    bindService[AttributeProcessParaService].to(wire[AttributeProcessParaServiceImpl]),
    bindService[AttributeTrlService].to(wire[AttributeTrlServiceImpl]),
    bindService[AttributeValueExtendService].to(wire[AttributeValueExtendServiceImpl]),

    bindService[BrowseService].to(wire[BrowseServiceImpl]),
    bindService[BrowseAccessService].to(wire[BrowseAccessServiceImpl]),
    bindService[BrowseFieldService].to(wire[BrowseFieldServiceImpl]),
    bindService[BrowseFieldTrlService].to(wire[BrowseFieldTrlServiceImpl]),
    bindService[BrowseTrlService].to(wire[BrowseTrlServiceImpl]),

    bindService[ChangeLogService].to(wire[ChangeLogServiceImpl]),
    bindService[ChartService].to(wire[ChartServiceImpl]),
    bindService[ChartDataSourceService].to(wire[ChartDataSourceServiceImpl]),
    bindService[ColorService].to(wire[ColorServiceImpl]),

    bindService[DesktopService].to(wire[DesktopServiceImpl]),
    bindService[DesktopTrlService].to(wire[DesktopTrlServiceImpl]),
    bindService[DesktopWorkbenchService].to(wire[DesktopWorkbenchServiceImpl]),
    bindService[DocumentActionAccessService].to(wire[DocumentActionAccessServiceImpl]),
    bindService[DynamicValidationRuleService].to(wire[DynamicValidationRuleServiceImpl]),

    bindService[ElementService].to(wire[ElementServiceImpl]),
    bindService[ElementTrlService].to(wire[ElementTrlServiceImpl]),
    bindService[EmailConfigService].to(wire[EmailConfigServiceImpl]),
    bindService[EntityService].to(wire[EntityServiceImpl]),
    bindService[EntityTypeService].to(wire[EntityTypeServiceImpl]),
    bindService[ErrorService].to(wire[ErrorServiceImpl]),

    bindService[FieldService].to(wire[FieldServiceImpl]),
    bindService[FieldGroupService].to(wire[FieldGroupServiceImpl]),
    bindService[FieldGroupTrlService].to(wire[FieldGroupTrlServiceImpl]),
    bindService[FieldTrlService].to(wire[FieldTrlServiceImpl]),
    bindService[FindService].to(wire[FindServiceImpl]),
    bindService[FormService].to(wire[FormServiceImpl]),
    bindService[FormAccessService].to(wire[FormAccessServiceImpl]),
    bindService[FormTrlService].to(wire[FormTrlServiceImpl]),

    bindService[HouseKeepingService].to(wire[HouseKeepingServiceImpl]),

    bindService[ImageService].to(wire[ImageServiceImpl]),
    bindService[ImportFormatService].to(wire[ImportFormatServiceImpl]),
    bindService[ImportFormatRowService].to(wire[ImportFormatRowServiceImpl]),
    bindService[InfoColumnTrlService].to(wire[InfoColumnTrlServiceImpl]),
    bindService[InformationColumnService].to(wire[InformationColumnServiceImpl]),
    bindService[InformationWindowService].to(wire[InformationWindowServiceImpl]),
    bindService[InformationWindowTrlService].to(wire[InformationWindowTrlServiceImpl]),
    bindService[IssueService].to(wire[IssueServiceImpl]),

    bindService[LabelPrinterService].to(wire[LabelPrinterServiceImpl]),
    bindService[LabelPrinterFunctionService].to(wire[LabelPrinterFunctionServiceImpl]),
    bindService[LanguageService].to(wire[LanguageServiceImpl]),
    bindService[LdapAccessService].to(wire[LdapAccessServiceImpl]),
    bindService[LdapProcessorService].to(wire[LdapProcessorServiceImpl]),
    bindService[LdapProcessorLogService].to(wire[LdapProcessorLogServiceImpl]),

    bindService[MemoService].to(wire[MemoServiceImpl]),
    bindService[MenuService].to(wire[MenuServiceImpl]),
    bindService[MenuTrlService].to(wire[MenuTrlServiceImpl]),
    bindService[MessageService].to(wire[MessageServiceImpl]),
    bindService[MessageTrlService].to(wire[MessageTrlServiceImpl]),
    bindService[MigrationService].to(wire[MigrationServiceImpl]),
    bindService[MigrationDataService].to(wire[MigrationDataServiceImpl]),
    bindService[MigrationScriptService].to(wire[MigrationScriptServiceImpl]),
    bindService[MigrationStepService].to(wire[MigrationStepServiceImpl]),
    bindService[ModelValidatorService].to(wire[ModelValidatorServiceImpl]),
    bindService[ModificationService].to(wire[ModificationServiceImpl]),

    bindService[NoteService].to(wire[NoteServiceImpl]),

    bindService[OrganizationService].to(wire[OrganizationServiceImpl]),
    bindService[OrganizationInfoService].to(wire[OrganizationInfoServiceImpl]),
    bindService[OrganizationTypeService].to(wire[OrganizationTypeServiceImpl]),

    bindService[PackageExportService].to(wire[PackageExportServiceImpl]),
    bindService[PackageExportCommonService].to(wire[PackageExportCommonServiceImpl]),
    bindService[PackageExportDetailService].to(wire[PackageExportDetailServiceImpl]),
    bindService[PackageImportService].to(wire[PackageImportServiceImpl]),
    bindService[PackageImportBackupService].to(wire[PackageImportBackupServiceImpl]),
    bindService[PackageImportDetailService].to(wire[PackageImportDetailServiceImpl]),
    bindService[PackageImportInstallService].to(wire[PackageImportInstallServiceImpl]),
    bindService[PackageImportProcessService].to(wire[PackageImportProcessServiceImpl]),
    bindService[PinStanceService].to(wire[PinStanceServiceImpl]),
    bindService[PinStanceLogService].to(wire[PinStanceLogServiceImpl]),
    bindService[PinStanceParaService].to(wire[PinStanceParaServiceImpl]),
    bindService[PreferenceService].to(wire[PreferenceServiceImpl]),
    bindService[PrintColorService].to(wire[PrintColorServiceImpl]),
    bindService[PrintFontService].to(wire[PrintFontServiceImpl]),
    bindService[PrintFormService].to(wire[PrintFormServiceImpl]),
    bindService[PrintFormatService].to(wire[PrintFormatServiceImpl]),
    bindService[PrintFormatItemService].to(wire[PrintFormatItemServiceImpl]),
    bindService[PrintFormatItemTrlService].to(wire[PrintFormatItemTrlServiceImpl]),
    bindService[PrintGraphService].to(wire[PrintGraphServiceImpl]),
    bindService[PrintLabelService].to(wire[PrintLabelServiceImpl]),
    bindService[PrintLabelLineService].to(wire[PrintLabelLineServiceImpl]),
    bindService[PrintLabelLineTrlService].to(wire[PrintLabelLineTrlServiceImpl]),
    bindService[PrintPaperService].to(wire[PrintPaperServiceImpl]),
    bindService[PrintTableFormatService].to(wire[PrintTableFormatServiceImpl]),
    bindService[PrivateAccessService].to(wire[PrivateAccessServiceImpl]),
    bindService[ProcessService].to(wire[ProcessServiceImpl]),
    bindService[ProcessAccessService].to(wire[ProcessAccessServiceImpl]),
    bindService[ProcessParameterService].to(wire[ProcessParameterServiceImpl]),
    bindService[ProcessParameterTrlService].to(wire[ProcessParameterTrlServiceImpl]),
    bindService[ProcessTrlService].to(wire[ProcessTrlServiceImpl]),

    bindService[RecentItemService].to(wire[RecentItemServiceImpl]),
    bindService[RecordAccessService].to(wire[RecordAccessServiceImpl]),
    bindService[ReferenceService].to(wire[ReferenceServiceImpl]),
    bindService[ReferenceEntityService].to(wire[ReferenceEntityServiceImpl]),
    bindService[ReferenceListService].to(wire[ReferenceListServiceImpl]),
    bindService[ReferenceListTrlService].to(wire[ReferenceListTrlServiceImpl]),
    bindService[ReferenceTrlService].to(wire[ReferenceTrlServiceImpl]),
    bindService[RegistrationService].to(wire[RegistrationServiceImpl]),
    bindService[RelationTypeService].to(wire[RelationTypeServiceImpl]),
    bindService[ReplicationService].to(wire[ReplicationServiceImpl]),
    bindService[ReplicationDocumentService].to(wire[ReplicationDocumentServiceImpl]),
    bindService[ReplicationLogService].to(wire[ReplicationLogServiceImpl]),
    bindService[ReplicationOrganizationAccessService].to(wire[ReplicationOrganizationAccessServiceImpl]),
    bindService[ReplicationRoleAccessService].to(wire[ReplicationRoleAccessServiceImpl]),
    bindService[ReplicationRunService].to(wire[ReplicationRunServiceImpl]),
    bindService[ReplicationStrategyService].to(wire[ReplicationStrategyServiceImpl]),
    bindService[ReplicationTableService].to(wire[ReplicationTableServiceImpl]),
    bindService[ReportViewService].to(wire[ReportViewServiceImpl]),
    bindService[ReportViewAttributeService].to(wire[ReportViewAttributeServiceImpl]),
    bindService[ReportViewTrlService].to(wire[ReportViewTrlServiceImpl]),
    bindService[RoleService].to(wire[RoleServiceImpl]),
    bindService[RoleIncludedService].to(wire[RoleIncludedServiceImpl]),
    bindService[RoleOrganizationAccessService].to(wire[RoleOrganizationAccessServiceImpl]),
    bindService[RuleService].to(wire[RuleServiceImpl]),

    bindService[SchedulerService].to(wire[SchedulerServiceImpl]),
    bindService[SchedulerLogService].to(wire[SchedulerLogServiceImpl]),
    bindService[SchedulerParameterService].to(wire[SchedulerParameterServiceImpl]),
    bindService[SchedulerRecipientService].to(wire[SchedulerRecipientServiceImpl]),
    bindService[SearchDefinitionService].to(wire[SearchDefinitionServiceImpl]),
    bindService[SequenceService].to(wire[SequenceServiceImpl]),
    bindService[SequenceAuditService].to(wire[SequenceAuditServiceImpl]),
    bindService[SequenceNoService].to(wire[SequenceNoServiceImpl]),
    bindService[SessionService].to(wire[SessionServiceImpl]),
    bindService[SysConfigService].to(wire[SysConfigServiceImpl]),
    bindService[SystemService].to(wire[SystemServiceImpl]),

    bindService[TabService].to(wire[TabServiceImpl]),
    bindService[TabTrlService].to(wire[TabTrlServiceImpl]),
    bindService[TaskService].to(wire[TaskServiceImpl]),
    bindService[TaskAccessService].to(wire[TaskAccessServiceImpl]),
    bindService[TaskInstanceService].to(wire[TaskInstanceServiceImpl]),
    bindService[TaskTrlService].to(wire[TaskTrlServiceImpl]),
    bindService[TenantService].to(wire[TenantServiceImpl]),
    bindService[TenantInfoService].to(wire[TenantInfoServiceImpl]),
    bindService[TenantShareService].to(wire[TenantShareServiceImpl]),
    bindService[TreeService].to(wire[TreeServiceImpl]),
    bindService[TreeBarService].to(wire[TreeBarServiceImpl]),
    bindService[TreeFavoriteService].to(wire[TreeFavoriteServiceImpl]),
    bindService[TreeFavoriteNodeService].to(wire[TreeFavoriteNodeServiceImpl]),
    bindService[TreeNodeService].to(wire[TreeNodeServiceImpl]),
    bindService[TreeNodeBPService].to(wire[TreeNodeBPServiceImpl]),
    bindService[TreeNodeCMCService].to(wire[TreeNodeCMCServiceImpl]),
    bindService[TreeNodeCMMService].to(wire[TreeNodeCMMServiceImpl]),
    bindService[TreeNodeCMSService].to(wire[TreeNodeCMSServiceImpl]),
    bindService[TreeNodeCMTService].to(wire[TreeNodeCMTServiceImpl]),
    bindService[TreeNodeMMService].to(wire[TreeNodeMMServiceImpl]),
    bindService[TreeNodePRService].to(wire[TreeNodePRServiceImpl]),
    bindService[TreeNodeU1Service].to(wire[TreeNodeU1ServiceImpl]),
    bindService[TreeNodeU2Service].to(wire[TreeNodeU2ServiceImpl]),
    bindService[TreeNodeU3Service].to(wire[TreeNodeU3ServiceImpl]),
    bindService[TreeNodeU4Service].to(wire[TreeNodeU4ServiceImpl]),

    bindService[UserService].to(wire[UserServiceImpl]),
    bindService[UserBusinessPartnerAccessService].to(wire[UserBusinessPartnerAccessServiceImpl]),
    bindService[UserDefinedFieldService].to(wire[UserDefinedFieldServiceImpl]),
    bindService[UserDefinedTabService].to(wire[UserDefinedTabServiceImpl]),
    bindService[UserDefinedWindowService].to(wire[UserDefinedWindowServiceImpl]),
    bindService[UserMailService].to(wire[UserMailServiceImpl]),
    bindService[UserOrganizationAccessService].to(wire[UserOrganizationAccessServiceImpl]),
    bindService[UserQueryService].to(wire[UserQueryServiceImpl]),
    bindService[UserRolesService].to(wire[UserRolesServiceImpl]),
    bindService[UserSubstituteService].to(wire[UserSubstituteServiceImpl]),

    bindService[ViewService].to(wire[ViewServiceImpl]),
    bindService[ViewAttributeService].to(wire[ViewAttributeServiceImpl]),
    bindService[ViewAttributeTrlService].to(wire[ViewAttributeTrlServiceImpl]),
    bindService[ViewDefinitionService].to(wire[ViewDefinitionServiceImpl]),
    bindService[ViewTrlService].to(wire[ViewTrlServiceImpl]),

    bindService[WindowService].to(wire[WindowServiceImpl]),
    bindService[WindowAccessService].to(wire[WindowAccessServiceImpl]),
    bindService[WindowTrlService].to(wire[WindowTrlServiceImpl]),
    bindService[WorkbenchService].to(wire[WorkbenchServiceImpl]),
    bindService[WorkbenchTrlService].to(wire[WorkbenchTrlServiceImpl]),
    bindService[WorkbenchWindowService].to(wire[WorkbenchWindowServiceImpl]),
    bindService[WorkflowService].to(wire[WorkflowServiceImpl]),
    bindService[WorkflowAccessService].to(wire[WorkflowAccessServiceImpl]),
    bindService[WorkflowActivityService].to(wire[WorkflowActivityServiceImpl]),
    bindService[WorkflowActivityResultService].to(wire[WorkflowActivityResultServiceImpl]),
    bindService[WorkflowBlockService].to(wire[WorkflowBlockServiceImpl]),
    bindService[WorkflowEventAuditService].to(wire[WorkflowEventAuditServiceImpl]),
    bindService[WorkflowNextConditionService].to(wire[WorkflowNextConditionServiceImpl]),
    bindService[WorkflowNodeService].to(wire[WorkflowNodeServiceImpl]),
    bindService[WorkflowNodeNextService].to(wire[WorkflowNodeNextServiceImpl]),
    bindService[WorkflowNodeParaService].to(wire[WorkflowNodeParaServiceImpl]),
    bindService[WorkflowNodeTrlService].to(wire[WorkflowNodeTrlServiceImpl]),
    bindService[WorkflowProcessService].to(wire[WorkflowProcessServiceImpl]),
    bindService[WorkflowProcessDataService].to(wire[WorkflowProcessDataServiceImpl]),
    bindService[WorkflowProcessorService].to(wire[WorkflowProcessorServiceImpl]),
    bindService[WorkflowProcessorLogService].to(wire[WorkflowProcessorLogServiceImpl]),
    bindService[WorkflowResponsibleService].to(wire[WorkflowResponsibleServiceImpl]),
    bindService[WorkflowTrlService].to(wire[WorkflowTrlServiceImpl]),

    bindService[ZoomConditionService].to(wire[ZoomConditionServiceImpl])
  )

  lazy val accessLogRepository = wire[AccessLogRepository]
  lazy val alertRepository = wire[AlertRepository]
  lazy val alertProcessorRepository = wire[AlertProcessorRepository]
  lazy val alertProcessorLogRepository = wire[AlertProcessorLogRepository]
  lazy val alertRecipientRepository = wire[AlertRecipientRepository]
  lazy val alertRuleRepository = wire[AlertRuleRepository]
  lazy val archiveRepository = wire[ArchiveRepository]
  lazy val attachmentRepository = wire[AttachmentRepository]
  lazy val attachmentNoteRepository = wire[AttachmentNoteRepository]
  lazy val attributeRepository = wire[AttributeRepository]
  lazy val attributeAccessRepository = wire[AttributeAccessRepository]
  lazy val attributeExtendRepository = wire[AttributeExtendRepository]
  lazy val attributeProcessRepository = wire[AttributeProcessRepository]
  lazy val attributeProcessParaRepository = wire[AttributeProcessParaRepository]
  lazy val attributeTrlRepository = wire[AttributeTrlRepository]
  lazy val attributeValueExtendRepository = wire[AttributeValueExtendRepository]

  lazy val browseRepository = wire[BrowseRepository]
  lazy val browseAccessRepository = wire[BrowseAccessRepository]
  lazy val browseFieldRepository = wire[BrowseFieldRepository]
  lazy val browseFieldTrlRepository = wire[BrowseFieldTrlRepository]
  lazy val browseTrlRepository = wire[BrowseTrlRepository]

  lazy val changeLogRepository = wire[ChangeLogRepository]
  lazy val chartRepository = wire[ChartRepository]
  lazy val chartDataSourceRepository = wire[ChartDataSourceRepository]
  lazy val colorRepository = wire[ColorRepository]

  lazy val desktopRepository = wire[DesktopRepository]
  lazy val desktopTrlRepository = wire[DesktopTrlRepository]
  lazy val desktopWorkbenchRepository = wire[DesktopWorkbenchRepository]
  lazy val documentActionAccessRepository = wire[DocumentActionAccessRepository]
  lazy val dynamicValidationRuleRepository = wire[DynamicValidationRuleRepository]

  lazy val elementRepository = wire[ElementRepository]
  lazy val elementTrlRepository = wire[ElementTrlRepository]
  lazy val emailConfigRepository = wire[EmailConfigRepository]
  lazy val entityRepository = wire[EntityRepository]
  lazy val entityTypeRepository = wire[EntityTypeRepository]
  lazy val errorRepository = wire[ErrorRepository]

  lazy val fieldRepository = wire[FieldRepository]
  lazy val fieldGroupRepository = wire[FieldGroupRepository]
  lazy val fieldGroupTrlRepository = wire[FieldGroupTrlRepository]
  lazy val fieldTrlRepository = wire[FieldTrlRepository]
  lazy val findRepository = wire[FindRepository]
  lazy val formRepository = wire[FormRepository]
  lazy val formAccessRepository = wire[FormAccessRepository]
  lazy val formTrlRepository = wire[FormTrlRepository]

  lazy val houseKeepingRepository = wire[HouseKeepingRepository]

  lazy val imageRepository = wire[ImageRepository]
  lazy val importFormatRepository = wire[ImportFormatRepository]
  lazy val importFormatRowRepository = wire[ImportFormatRowRepository]
  lazy val infoColumnTrlRepository = wire[InfoColumnTrlRepository]
  lazy val informationColumnRepository = wire[InformationColumnRepository]
  lazy val informationWindowRepository = wire[InformationWindowRepository]
  lazy val informationWindowTrlRepository = wire[InformationWindowTrlRepository]
  lazy val issueRepository = wire[IssueRepository]

  lazy val labelPrinterRepository = wire[LabelPrinterRepository]
  lazy val labelPrinterFunctionRepository = wire[LabelPrinterFunctionRepository]
  lazy val languageRepository = wire[LanguageRepository]
  lazy val ldapAccessRepository = wire[LdapAccessRepository]
  lazy val ldapProcessorRepository = wire[LdapProcessorRepository]
  lazy val ldapProcessorLogRepository = wire[LdapProcessorLogRepository]

  lazy val memoRepository = wire[MemoRepository]
  lazy val menuRepository = wire[MenuRepository]
  lazy val menuTrlRepository = wire[MenuTrlRepository]
  lazy val messageRepository = wire[MessageRepository]
  lazy val messageTrlRepository = wire[MessageTrlRepository]
  lazy val migrationRepository = wire[MigrationRepository]
  lazy val migrationDataRepository = wire[MigrationDataRepository]
  lazy val migrationScriptRepository = wire[MigrationScriptRepository]
  lazy val migrationStepRepository = wire[MigrationStepRepository]
  lazy val modelValidatorRepository = wire[ModelValidatorRepository]
  lazy val modificationRepository = wire[ModificationRepository]

  lazy val noteRepository = wire[NoteRepository]

  lazy val organizationRepository = wire[OrganizationRepository]
  lazy val organizationInfoRepository = wire[OrganizationInfoRepository]
  lazy val organizationTypeRepository = wire[OrganizationTypeRepository]

  lazy val packageExportRepository = wire[PackageExportRepository]
  lazy val packageExportCommonRepository = wire[PackageExportCommonRepository]
  lazy val packageExportDetailRepository = wire[PackageExportDetailRepository]
  lazy val packageImportRepository = wire[PackageImportRepository]
  lazy val packageImportBackupRepository = wire[PackageImportBackupRepository]
  lazy val packageImportDetailRepository = wire[PackageImportDetailRepository]
  lazy val packageImportInstallRepository = wire[PackageImportInstallRepository]
  lazy val packageImportProcessRepository = wire[PackageImportProcessRepository]
  lazy val pinStanceRepository = wire[PinStanceRepository]
  lazy val pinStanceLogRepository = wire[PinStanceLogRepository]
  lazy val pinStanceParaRepository = wire[PinStanceParaRepository]
  lazy val preferenceRepository = wire[PreferenceRepository]
  lazy val printColorRepository = wire[PrintColorRepository]
  lazy val printFontRepository = wire[PrintFontRepository]
  lazy val printFormRepository = wire[PrintFormRepository]
  lazy val printFormatRepository = wire[PrintFormatRepository]
  lazy val printFormatItemRepository = wire[PrintFormatItemRepository]
  lazy val printFormatItemTrlRepository = wire[PrintFormatItemTrlRepository]
  lazy val printGraphRepository = wire[PrintGraphRepository]
  lazy val printLabelRepository = wire[PrintLabelRepository]
  lazy val printLabelLineRepository = wire[PrintLabelLineRepository]
  lazy val printLabelLineTrlRepository = wire[PrintLabelLineTrlRepository]
  lazy val printPaperRepository = wire[PrintPaperRepository]
  lazy val printTableFormatRepository = wire[PrintTableFormatRepository]
  lazy val privateAccessRepository = wire[PrivateAccessRepository]
  lazy val processRepository = wire[ProcessRepository]
  lazy val processAccessRepository = wire[ProcessAccessRepository]
  lazy val processParameterRepository = wire[ProcessParameterRepository]
  lazy val processParameterTrlRepository = wire[ProcessParameterTrlRepository]
  lazy val processTrlRepository = wire[ProcessTrlRepository]

  lazy val recentItemRepository = wire[RecentItemRepository]
  lazy val recordAccessRepository = wire[RecordAccessRepository]
  lazy val referenceRepository = wire[ReferenceRepository]
  lazy val referenceEntityRepository = wire[ReferenceEntityRepository]
  lazy val referenceListRepository = wire[ReferenceListRepository]
  lazy val referenceListTrlRepository = wire[ReferenceListTrlRepository]
  lazy val referenceTrlRepository = wire[ReferenceTrlRepository]
  lazy val registrationRepository = wire[RegistrationRepository]
  lazy val relationTypeRepository = wire[RelationTypeRepository]
  lazy val replicationRepository = wire[ReplicationRepository]
  lazy val replicationDocumentRepository = wire[ReplicationDocumentRepository]
  lazy val replicationLogRepository = wire[ReplicationLogRepository]
  lazy val replicationOrganizationAccessRepository = wire[ReplicationOrganizationAccessRepository]
  lazy val replicationRoleAccessRepository = wire[ReplicationRoleAccessRepository]
  lazy val replicationRunRepository = wire[ReplicationRunRepository]
  lazy val replicationStrategyRepository = wire[ReplicationStrategyRepository]
  lazy val replicationTableRepository = wire[ReplicationTableRepository]
  lazy val reportViewRepository = wire[ReportViewRepository]
  lazy val reportViewAttributeRepository = wire[ReportViewAttributeRepository]
  lazy val reportViewTrlRepository = wire[ReportViewTrlRepository]
  lazy val roleRepository = wire[RoleRepository]
  lazy val roleIncludedRepository = wire[RoleIncludedRepository]
  lazy val roleOrganizationAccessRepository = wire[RoleOrganizationAccessRepository]
  lazy val ruleRepository = wire[RuleRepository]

  lazy val schedulerRepository = wire[SchedulerRepository]
  lazy val schedulerLogRepository = wire[SchedulerLogRepository]
  lazy val schedulerParameterRepository = wire[SchedulerParameterRepository]
  lazy val schedulerRecipientRepository = wire[SchedulerRecipientRepository]
  lazy val searchDefinitionRepository = wire[SearchDefinitionRepository]
  lazy val sequenceRepository = wire[SequenceRepository]
  lazy val sequenceAuditRepository = wire[SequenceAuditRepository]
  lazy val sequenceNoRepository = wire[SequenceNoRepository]
  lazy val sessionRepository = wire[SessionRepository]
  lazy val sysConfigRepository = wire[SysConfigRepository]
  lazy val systemRepository = wire[SystemRepository]

  lazy val tabRepository = wire[TabRepository]
  lazy val tabTrlRepository = wire[TabTrlRepository]
  lazy val taskRepository = wire[TaskRepository]
  lazy val taskAccessRepository = wire[TaskAccessRepository]
  lazy val taskInstanceRepository = wire[TaskInstanceRepository]
  lazy val taskTrlRepository = wire[TaskTrlRepository]
  lazy val tenantRepository = wire[TenantRepository]
  lazy val tenantInfoRepository = wire[TenantInfoRepository]
  lazy val tenantShareRepository = wire[TenantShareRepository]
  lazy val treeRepository = wire[TreeRepository]
  lazy val treeBarRepository = wire[TreeBarRepository]
  lazy val treeFavoriteRepository = wire[TreeFavoriteRepository]
  lazy val treeFavoriteNodeRepository = wire[TreeFavoriteNodeRepository]
  lazy val treeNodeRepository = wire[TreeNodeRepository]
  lazy val treeNodeBPRepository = wire[TreeNodeBPRepository]
  lazy val treeNodeCMCRepository = wire[TreeNodeCMCRepository]
  lazy val treeNodeCMMRepository = wire[TreeNodeCMMRepository]
  lazy val treeNodeCMSRepository = wire[TreeNodeCMSRepository]
  lazy val treeNodeCMTRepository = wire[TreeNodeCMTRepository]
  lazy val treeNodeMMRepository = wire[TreeNodeMMRepository]
  lazy val treeNodePRRepository = wire[TreeNodePRRepository]
  lazy val treeNodeU1Repository = wire[TreeNodeU1Repository]
  lazy val treeNodeU2Repository = wire[TreeNodeU2Repository]
  lazy val treeNodeU3Repository = wire[TreeNodeU3Repository]
  lazy val treeNodeU4Repository = wire[TreeNodeU4Repository]

  lazy val userRepository = wire[UserRepository]
  lazy val userBusinessPartnerAccessRepository = wire[UserBusinessPartnerAccessRepository]
  lazy val userDefinedFieldRepository = wire[UserDefinedFieldRepository]
  lazy val userDefinedTabRepository = wire[UserDefinedTabRepository]
  lazy val userDefinedWindowRepository = wire[UserDefinedWindowRepository]
  lazy val userMailRepository = wire[UserMailRepository]
  lazy val userOrganizationAccessRepository = wire[UserOrganizationAccessRepository]
  lazy val userQueryRepository = wire[UserQueryRepository]
  lazy val userRolesRepository = wire[UserRolesRepository]
  lazy val userSubstituteRepository = wire[UserSubstituteRepository]

  lazy val viewRepository = wire[ViewRepository]
  lazy val viewAttributeRepository = wire[ViewAttributeRepository]
  lazy val viewAttributeTrlRepository = wire[ViewAttributeTrlRepository]
  lazy val viewDefinitionRepository = wire[ViewDefinitionRepository]
  lazy val viewTrlRepository = wire[ViewTrlRepository]

  lazy val windowRepository = wire[WindowRepository]
  lazy val windowAccessRepository = wire[WindowAccessRepository]
  lazy val windowTrlRepository = wire[WindowTrlRepository]
  lazy val workbenchRepository = wire[WorkbenchRepository]
  lazy val workbenchTrlRepository = wire[WorkbenchTrlRepository]
  lazy val workbenchWindowRepository = wire[WorkbenchWindowRepository]
  lazy val workflowRepository = wire[WorkflowRepository]
  lazy val workflowAccessRepository = wire[WorkflowAccessRepository]
  lazy val workflowActivityRepository = wire[WorkflowActivityRepository]
  lazy val workflowActivityResultRepository = wire[WorkflowActivityResultRepository]
  lazy val workflowBlockRepository = wire[WorkflowBlockRepository]
  lazy val workflowEventAuditRepository = wire[WorkflowEventAuditRepository]
  lazy val workflowNextConditionRepository = wire[WorkflowNextConditionRepository]
  lazy val workflowNodeRepository = wire[WorkflowNodeRepository]
  lazy val workflowNodeNextRepository = wire[WorkflowNodeNextRepository]
  lazy val workflowNodeParaRepository = wire[WorkflowNodeParaRepository]
  lazy val workflowNodeTrlRepository = wire[WorkflowNodeTrlRepository]
  lazy val workflowProcessRepository = wire[WorkflowProcessRepository]
  lazy val workflowProcessDataRepository = wire[WorkflowProcessDataRepository]
  lazy val workflowProcessorRepository = wire[WorkflowProcessorRepository]
  lazy val workflowProcessorLogRepository = wire[WorkflowProcessorLogRepository]
  lazy val workflowResponsibleRepository = wire[WorkflowResponsibleRepository]
  lazy val workflowTrlRepository = wire[WorkflowTrlRepository]

  lazy val zoomConditionRepository = wire[ZoomConditionRepository]

  lazy val jsonSerializerRegistry = DictionarySerializerRegistry

}

/**
  * Entity Application
  * @param context
  */

 abstract class DictionaryApplication(context: LagomApplicationContext) extends LagomApplication(context)
  with DictionaryComponents
  with AhcWSComponents {

  override lazy val lagomServer = LagomServer.forServices(
    bindService[AccessLogService].to(wire[AccessLogServiceImpl]),
    bindService[AlertService].to(wire[AlertServiceImpl]),
    bindService[AlertProcessorService].to(wire[AlertProcessorServiceImpl]),
    bindService[AlertProcessorLogService].to(wire[AlertProcessorLogServiceImpl]),
    bindService[AlertRecipientService].to(wire[AlertRecipientServiceImpl]),
    bindService[AlertRuleService].to(wire[AlertRuleServiceImpl]),
    bindService[ArchiveService].to(wire[ArchiveServiceImpl]),
    bindService[AttachmentService].to(wire[AttachmentServiceImpl]),
    bindService[AttachmentNoteService].to(wire[AttachmentNoteServiceImpl]),
    bindService[AttributeService].to(wire[AttributeServiceImpl]),
    bindService[AttributeAccessService].to(wire[AttributeAccessServiceImpl]),
    bindService[AttributeExtendService].to(wire[AttributeExtendServiceImpl]),
    bindService[AttributeProcessService].to(wire[AttributeProcessServiceImpl]),
    bindService[AttributeProcessParaService].to(wire[AttributeProcessParaServiceImpl]),
    bindService[AttributeTrlService].to(wire[AttributeTrlServiceImpl]),
    bindService[AttributeValueExtendService].to(wire[AttributeValueExtendServiceImpl]),

    bindService[BrowseService].to(wire[BrowseServiceImpl]),
    bindService[BrowseAccessService].to(wire[BrowseAccessServiceImpl]),
    bindService[BrowseFieldService].to(wire[BrowseFieldServiceImpl]),
    bindService[BrowseFieldTrlService].to(wire[BrowseFieldTrlServiceImpl]),
    bindService[BrowseTrlService].to(wire[BrowseTrlServiceImpl]),

    bindService[ChangeLogService].to(wire[ChangeLogServiceImpl]),
    bindService[ChartService].to(wire[ChartServiceImpl]),
    bindService[ChartDataSourceService].to(wire[ChartDataSourceServiceImpl]),
    bindService[ColorService].to(wire[ColorServiceImpl]),

    bindService[DesktopService].to(wire[DesktopServiceImpl]),
    bindService[DesktopTrlService].to(wire[DesktopTrlServiceImpl]),
    bindService[DesktopWorkbenchService].to(wire[DesktopWorkbenchServiceImpl]),
    bindService[DocumentActionAccessService].to(wire[DocumentActionAccessServiceImpl]),
    bindService[DynamicValidationRuleService].to(wire[DynamicValidationRuleServiceImpl]),

    bindService[ElementService].to(wire[ElementServiceImpl]),
    bindService[ElementTrlService].to(wire[ElementTrlServiceImpl]),
    bindService[EmailConfigService].to(wire[EmailConfigServiceImpl]),
    bindService[EntityService].to(wire[EntityServiceImpl]),
    bindService[EntityTypeService].to(wire[EntityTypeServiceImpl]),
    bindService[ErrorService].to(wire[ErrorServiceImpl]),

    bindService[FieldService].to(wire[FieldServiceImpl]),
    bindService[FieldGroupService].to(wire[FieldGroupServiceImpl]),
    bindService[FieldGroupTrlService].to(wire[FieldGroupTrlServiceImpl]),
    bindService[FieldTrlService].to(wire[FieldTrlServiceImpl]),
    bindService[FindService].to(wire[FindServiceImpl]),
    bindService[FormService].to(wire[FormServiceImpl]),
    bindService[FormAccessService].to(wire[FormAccessServiceImpl]),
    bindService[FormTrlService].to(wire[FormTrlServiceImpl]),

    bindService[HouseKeepingService].to(wire[HouseKeepingServiceImpl]),

    bindService[ImageService].to(wire[ImageServiceImpl]),
    bindService[ImportFormatService].to(wire[ImportFormatServiceImpl]),
    bindService[ImportFormatRowService].to(wire[ImportFormatRowServiceImpl]),
    bindService[InfoColumnTrlService].to(wire[InfoColumnTrlServiceImpl]),
    bindService[InformationColumnService].to(wire[InformationColumnServiceImpl]),
    bindService[InformationWindowService].to(wire[InformationWindowServiceImpl]),
    bindService[InformationWindowTrlService].to(wire[InformationWindowTrlServiceImpl]),
    bindService[IssueService].to(wire[IssueServiceImpl]),

    bindService[LabelPrinterService].to(wire[LabelPrinterServiceImpl]),
    bindService[LabelPrinterFunctionService].to(wire[LabelPrinterFunctionServiceImpl]),
    bindService[LanguageService].to(wire[LanguageServiceImpl]),
    bindService[LdapAccessService].to(wire[LdapAccessServiceImpl]),
    bindService[LdapProcessorService].to(wire[LdapProcessorServiceImpl]),
    bindService[LdapProcessorLogService].to(wire[LdapProcessorLogServiceImpl]),

    bindService[MemoService].to(wire[MemoServiceImpl]),
    bindService[MenuService].to(wire[MenuServiceImpl]),
    bindService[MenuTrlService].to(wire[MenuTrlServiceImpl]),
    bindService[MessageService].to(wire[MessageServiceImpl]),
    bindService[MessageTrlService].to(wire[MessageTrlServiceImpl]),
    bindService[MigrationService].to(wire[MigrationServiceImpl]),
    bindService[MigrationDataService].to(wire[MigrationDataServiceImpl]),
    bindService[MigrationScriptService].to(wire[MigrationScriptServiceImpl]),
    bindService[MigrationStepService].to(wire[MigrationStepServiceImpl]),
    bindService[ModelValidatorService].to(wire[ModelValidatorServiceImpl]),
    bindService[ModificationService].to(wire[ModificationServiceImpl]),

    bindService[NoteService].to(wire[NoteServiceImpl]),

    bindService[OrganizationService].to(wire[OrganizationServiceImpl]),
    bindService[OrganizationInfoService].to(wire[OrganizationInfoServiceImpl]),
    bindService[OrganizationTypeService].to(wire[OrganizationTypeServiceImpl]),

    bindService[PackageExportService].to(wire[PackageExportServiceImpl]),
    bindService[PackageExportCommonService].to(wire[PackageExportCommonServiceImpl]),
    bindService[PackageExportDetailService].to(wire[PackageExportDetailServiceImpl]),
    bindService[PackageImportService].to(wire[PackageImportServiceImpl]),
    bindService[PackageImportBackupService].to(wire[PackageImportBackupServiceImpl]),
    bindService[PackageImportDetailService].to(wire[PackageImportDetailServiceImpl]),
    bindService[PackageImportInstallService].to(wire[PackageImportInstallServiceImpl]),
    bindService[PackageImportProcessService].to(wire[PackageImportProcessServiceImpl]),
    bindService[PinStanceService].to(wire[PinStanceServiceImpl]),
    bindService[PinStanceLogService].to(wire[PinStanceLogServiceImpl]),
    bindService[PinStanceParaService].to(wire[PinStanceParaServiceImpl]),
    bindService[PreferenceService].to(wire[PreferenceServiceImpl]),
    bindService[PrintColorService].to(wire[PrintColorServiceImpl]),
    bindService[PrintFontService].to(wire[PrintFontServiceImpl]),
    bindService[PrintFormService].to(wire[PrintFormServiceImpl]),
    bindService[PrintFormatService].to(wire[PrintFormatServiceImpl]),
    bindService[PrintFormatItemService].to(wire[PrintFormatItemServiceImpl]),
    bindService[PrintFormatItemTrlService].to(wire[PrintFormatItemTrlServiceImpl]),
    bindService[PrintGraphService].to(wire[PrintGraphServiceImpl]),
    bindService[PrintLabelService].to(wire[PrintLabelServiceImpl]),
    bindService[PrintLabelLineService].to(wire[PrintLabelLineServiceImpl]),
    bindService[PrintLabelLineTrlService].to(wire[PrintLabelLineTrlServiceImpl]),
    bindService[PrintPaperService].to(wire[PrintPaperServiceImpl]),
    bindService[PrintTableFormatService].to(wire[PrintTableFormatServiceImpl]),
    bindService[PrivateAccessService].to(wire[PrivateAccessServiceImpl]),
    bindService[ProcessService].to(wire[ProcessServiceImpl]),
    bindService[ProcessAccessService].to(wire[ProcessAccessServiceImpl]),
    bindService[ProcessParameterService].to(wire[ProcessParameterServiceImpl]),
    bindService[ProcessParameterTrlService].to(wire[ProcessParameterTrlServiceImpl]),
    bindService[ProcessTrlService].to(wire[ProcessTrlServiceImpl]),

    bindService[RecentItemService].to(wire[RecentItemServiceImpl]),
    bindService[RecordAccessService].to(wire[RecordAccessServiceImpl]),
    bindService[ReferenceService].to(wire[ReferenceServiceImpl]),
    bindService[ReferenceEntityService].to(wire[ReferenceEntityServiceImpl]),
    bindService[ReferenceListService].to(wire[ReferenceListServiceImpl]),
    bindService[ReferenceListTrlService].to(wire[ReferenceListTrlServiceImpl]),
    bindService[ReferenceTrlService].to(wire[ReferenceTrlServiceImpl]),
    bindService[RegistrationService].to(wire[RegistrationServiceImpl]),
    bindService[RelationTypeService].to(wire[RelationTypeServiceImpl]),
    bindService[ReplicationService].to(wire[ReplicationServiceImpl]),
    bindService[ReplicationDocumentService].to(wire[ReplicationDocumentServiceImpl]),
    bindService[ReplicationLogService].to(wire[ReplicationLogServiceImpl]),
    bindService[ReplicationOrganizationAccessService].to(wire[ReplicationOrganizationAccessServiceImpl]),
    bindService[ReplicationRoleAccessService].to(wire[ReplicationRoleAccessServiceImpl]),
    bindService[ReplicationRunService].to(wire[ReplicationRunServiceImpl]),
    bindService[ReplicationStrategyService].to(wire[ReplicationStrategyServiceImpl]),
    bindService[ReplicationTableService].to(wire[ReplicationTableServiceImpl]),
    bindService[ReportViewService].to(wire[ReportViewServiceImpl]),
    bindService[ReportViewAttributeService].to(wire[ReportViewAttributeServiceImpl]),
    bindService[ReportViewTrlService].to(wire[ReportViewTrlServiceImpl]),
    bindService[RoleService].to(wire[RoleServiceImpl]),
    bindService[RoleIncludedService].to(wire[RoleIncludedServiceImpl]),
    bindService[RoleOrganizationAccessService].to(wire[RoleOrganizationAccessServiceImpl]),
    bindService[RuleService].to(wire[RuleServiceImpl]),

    bindService[SchedulerService].to(wire[SchedulerServiceImpl]),
    bindService[SchedulerLogService].to(wire[SchedulerLogServiceImpl]),
    bindService[SchedulerParameterService].to(wire[SchedulerParameterServiceImpl]),
    bindService[SchedulerRecipientService].to(wire[SchedulerRecipientServiceImpl]),
    bindService[SearchDefinitionService].to(wire[SearchDefinitionServiceImpl]),
    bindService[SequenceService].to(wire[SequenceServiceImpl]),
    bindService[SequenceAuditService].to(wire[SequenceAuditServiceImpl]),
    bindService[SequenceNoService].to(wire[SequenceNoServiceImpl]),
    bindService[SessionService].to(wire[SessionServiceImpl]),
    bindService[SysConfigService].to(wire[SysConfigServiceImpl]),
    bindService[SystemService].to(wire[SystemServiceImpl]),

    bindService[TabService].to(wire[TabServiceImpl]),
    bindService[TabTrlService].to(wire[TabTrlServiceImpl]),
    bindService[TaskService].to(wire[TaskServiceImpl]),
    bindService[TaskAccessService].to(wire[TaskAccessServiceImpl]),
    bindService[TaskInstanceService].to(wire[TaskInstanceServiceImpl]),
    bindService[TaskTrlService].to(wire[TaskTrlServiceImpl]),
    bindService[TenantService].to(wire[TenantServiceImpl]),
    bindService[TenantInfoService].to(wire[TenantInfoServiceImpl]),
    bindService[TenantShareService].to(wire[TenantShareServiceImpl]),
    bindService[TreeService].to(wire[TreeServiceImpl]),
    bindService[TreeBarService].to(wire[TreeBarServiceImpl]),
    bindService[TreeFavoriteService].to(wire[TreeFavoriteServiceImpl]),
    bindService[TreeFavoriteNodeService].to(wire[TreeFavoriteNodeServiceImpl]),
    bindService[TreeNodeService].to(wire[TreeNodeServiceImpl]),
    bindService[TreeNodeBPService].to(wire[TreeNodeBPServiceImpl]),
    bindService[TreeNodeCMCService].to(wire[TreeNodeCMCServiceImpl]),
    bindService[TreeNodeCMMService].to(wire[TreeNodeCMMServiceImpl]),
    bindService[TreeNodeCMSService].to(wire[TreeNodeCMSServiceImpl]),
    bindService[TreeNodeCMTService].to(wire[TreeNodeCMTServiceImpl]),
    bindService[TreeNodeMMService].to(wire[TreeNodeMMServiceImpl]),
    bindService[TreeNodePRService].to(wire[TreeNodePRServiceImpl]),
    bindService[TreeNodeU1Service].to(wire[TreeNodeU1ServiceImpl]),
    bindService[TreeNodeU2Service].to(wire[TreeNodeU2ServiceImpl]),
    bindService[TreeNodeU3Service].to(wire[TreeNodeU3ServiceImpl]),
    bindService[TreeNodeU4Service].to(wire[TreeNodeU4ServiceImpl]),

    bindService[UserService].to(wire[UserServiceImpl]),
    bindService[UserBusinessPartnerAccessService].to(wire[UserBusinessPartnerAccessServiceImpl]),
    bindService[UserDefinedFieldService].to(wire[UserDefinedFieldServiceImpl]),
    bindService[UserDefinedTabService].to(wire[UserDefinedTabServiceImpl]),
    bindService[UserDefinedWindowService].to(wire[UserDefinedWindowServiceImpl]),
    bindService[UserMailService].to(wire[UserMailServiceImpl]),
    bindService[UserOrganizationAccessService].to(wire[UserOrganizationAccessServiceImpl]),
    bindService[UserQueryService].to(wire[UserQueryServiceImpl]),
    bindService[UserRolesService].to(wire[UserRolesServiceImpl]),
    bindService[UserSubstituteService].to(wire[UserSubstituteServiceImpl]),

    bindService[ViewService].to(wire[ViewServiceImpl]),
    bindService[ViewAttributeService].to(wire[ViewAttributeServiceImpl]),
    bindService[ViewAttributeTrlService].to(wire[ViewAttributeTrlServiceImpl]),
    bindService[ViewDefinitionService].to(wire[ViewDefinitionServiceImpl]),
    bindService[ViewTrlService].to(wire[ViewTrlServiceImpl]),

    bindService[WindowService].to(wire[WindowServiceImpl]),
    bindService[WindowAccessService].to(wire[WindowAccessServiceImpl]),
    bindService[WindowTrlService].to(wire[WindowTrlServiceImpl]),
    bindService[WorkbenchService].to(wire[WorkbenchServiceImpl]),
    bindService[WorkbenchTrlService].to(wire[WorkbenchTrlServiceImpl]),
    bindService[WorkbenchWindowService].to(wire[WorkbenchWindowServiceImpl]),
    bindService[WorkflowService].to(wire[WorkflowServiceImpl]),
    bindService[WorkflowAccessService].to(wire[WorkflowAccessServiceImpl]),
    bindService[WorkflowActivityService].to(wire[WorkflowActivityServiceImpl]),
    bindService[WorkflowActivityResultService].to(wire[WorkflowActivityResultServiceImpl]),
    bindService[WorkflowBlockService].to(wire[WorkflowBlockServiceImpl]),
    bindService[WorkflowEventAuditService].to(wire[WorkflowEventAuditServiceImpl]),
    bindService[WorkflowNextConditionService].to(wire[WorkflowNextConditionServiceImpl]),
    bindService[WorkflowNodeService].to(wire[WorkflowNodeServiceImpl]),
    bindService[WorkflowNodeNextService].to(wire[WorkflowNodeNextServiceImpl]),
    bindService[WorkflowNodeParaService].to(wire[WorkflowNodeParaServiceImpl]),
    bindService[WorkflowNodeTrlService].to(wire[WorkflowNodeTrlServiceImpl]),
    bindService[WorkflowProcessService].to(wire[WorkflowProcessServiceImpl]),
    bindService[WorkflowProcessDataService].to(wire[WorkflowProcessDataServiceImpl]),
    bindService[WorkflowProcessorService].to(wire[WorkflowProcessorServiceImpl]),
    bindService[WorkflowProcessorLogService].to(wire[WorkflowProcessorLogServiceImpl]),
    bindService[WorkflowResponsibleService].to(wire[WorkflowResponsibleServiceImpl]),
    bindService[WorkflowTrlService].to(wire[WorkflowTrlServiceImpl]),

    bindService[ZoomConditionService].to(wire[ZoomConditionServiceImpl])
  )

  override lazy val accessLogRepository = wire[AccessLogRepository]
  override lazy val alertRepository = wire[AlertRepository]
  override lazy val alertProcessorRepository = wire[AlertProcessorRepository]
  override lazy val alertProcessorLogRepository = wire[AlertProcessorLogRepository]
  override lazy val alertRecipientRepository = wire[AlertRecipientRepository]
  override lazy val alertRuleRepository = wire[AlertRuleRepository]
  override lazy val archiveRepository = wire[ArchiveRepository]
  override lazy val attachmentRepository = wire[AttachmentRepository]
  override lazy val attachmentNoteRepository = wire[AttachmentNoteRepository]
  override lazy val attributeRepository = wire[AttributeRepository]
  override lazy val attributeAccessRepository = wire[AttributeAccessRepository]
  override lazy val attributeExtendRepository = wire[AttributeExtendRepository]
  override lazy val attributeProcessRepository = wire[AttributeProcessRepository]
  override lazy val attributeProcessParaRepository = wire[AttributeProcessParaRepository]
  override lazy val attributeTrlRepository = wire[AttributeTrlRepository]
  override lazy val attributeValueExtendRepository = wire[AttributeValueExtendRepository]

  override lazy val browseRepository = wire[BrowseRepository]
  override lazy val browseAccessRepository = wire[BrowseAccessRepository]
  override lazy val browseFieldRepository = wire[BrowseFieldRepository]
  override lazy val browseFieldTrlRepository = wire[BrowseFieldTrlRepository]
  override lazy val browseTrlRepository = wire[BrowseTrlRepository]

  override lazy val changeLogRepository = wire[ChangeLogRepository]
  override lazy val chartRepository = wire[ChartRepository]
  override lazy val chartDataSourceRepository = wire[ChartDataSourceRepository]
  override lazy val colorRepository = wire[ColorRepository]

  override lazy val desktopRepository = wire[DesktopRepository]
  override lazy val desktopTrlRepository = wire[DesktopTrlRepository]
  override lazy val desktopWorkbenchRepository = wire[DesktopWorkbenchRepository]
  override lazy val documentActionAccessRepository = wire[DocumentActionAccessRepository]
  override lazy val dynamicValidationRuleRepository = wire[DynamicValidationRuleRepository]

  override lazy val elementRepository = wire[ElementRepository]
  override lazy val elementTrlRepository = wire[ElementTrlRepository]
  override lazy val emailConfigRepository = wire[EmailConfigRepository]
  override lazy val entityRepository = wire[EntityRepository]
  override lazy val entityTypeRepository = wire[EntityTypeRepository]
  override lazy val errorRepository = wire[ErrorRepository]

  override lazy val fieldRepository = wire[FieldRepository]
  override lazy val fieldGroupRepository = wire[FieldGroupRepository]
  override lazy val fieldGroupTrlRepository = wire[FieldGroupTrlRepository]
  override lazy val fieldTrlRepository = wire[FieldTrlRepository]
  override lazy val findRepository = wire[FindRepository]
  override lazy val formRepository = wire[FormRepository]
  override lazy val formAccessRepository = wire[FormAccessRepository]
  override lazy val formTrlRepository = wire[FormTrlRepository]

  override lazy val houseKeepingRepository = wire[HouseKeepingRepository]

  override lazy val imageRepository = wire[ImageRepository]
  override lazy val importFormatRepository = wire[ImportFormatRepository]
  override lazy val importFormatRowRepository = wire[ImportFormatRowRepository]
  override lazy val infoColumnTrlRepository = wire[InfoColumnTrlRepository]
  override lazy val informationColumnRepository = wire[InformationColumnRepository]
  override lazy val informationWindowRepository = wire[InformationWindowRepository]
  override lazy val informationWindowTrlRepository = wire[InformationWindowTrlRepository]
  override lazy val issueRepository = wire[IssueRepository]

  override lazy val labelPrinterRepository = wire[LabelPrinterRepository]
  override lazy val labelPrinterFunctionRepository = wire[LabelPrinterFunctionRepository]
  override lazy val languageRepository = wire[LanguageRepository]
  override lazy val ldapAccessRepository = wire[LdapAccessRepository]
  override lazy val ldapProcessorRepository = wire[LdapProcessorRepository]
  override lazy val ldapProcessorLogRepository = wire[LdapProcessorLogRepository]

  override lazy val memoRepository = wire[MemoRepository]
  override lazy val menuRepository = wire[MenuRepository]
  override lazy val menuTrlRepository = wire[MenuTrlRepository]
  override lazy val messageRepository = wire[MessageRepository]
  override lazy val messageTrlRepository = wire[MessageTrlRepository]
  override lazy val migrationRepository = wire[MigrationRepository]
  override lazy val migrationDataRepository = wire[MigrationDataRepository]
  override lazy val migrationScriptRepository = wire[MigrationScriptRepository]
  override lazy val migrationStepRepository = wire[MigrationStepRepository]
  override lazy val modelValidatorRepository = wire[ModelValidatorRepository]
  override lazy val modificationRepository = wire[ModificationRepository]

  override lazy val noteRepository = wire[NoteRepository]

  override lazy val organizationRepository = wire[OrganizationRepository]
  override lazy val organizationInfoRepository = wire[OrganizationInfoRepository]
  override lazy val organizationTypeRepository = wire[OrganizationTypeRepository]

  override lazy val packageExportRepository = wire[PackageExportRepository]
  override lazy val packageExportCommonRepository = wire[PackageExportCommonRepository]
  override lazy val packageExportDetailRepository = wire[PackageExportDetailRepository]
  override lazy val packageImportRepository = wire[PackageImportRepository]
  override lazy val packageImportBackupRepository = wire[PackageImportBackupRepository]
  override lazy val packageImportDetailRepository = wire[PackageImportDetailRepository]
  override lazy val packageImportInstallRepository = wire[PackageImportInstallRepository]
  override lazy val packageImportProcessRepository = wire[PackageImportProcessRepository]
  override lazy val pinStanceRepository = wire[PinStanceRepository]
  override lazy val pinStanceLogRepository = wire[PinStanceLogRepository]
  override lazy val pinStanceParaRepository = wire[PinStanceParaRepository]
  override lazy val preferenceRepository = wire[PreferenceRepository]
  override lazy val printColorRepository = wire[PrintColorRepository]
  override lazy val printFontRepository = wire[PrintFontRepository]
  override lazy val printFormRepository = wire[PrintFormRepository]
  override lazy val printFormatRepository = wire[PrintFormatRepository]
  override lazy val printFormatItemRepository = wire[PrintFormatItemRepository]
  override lazy val printFormatItemTrlRepository = wire[PrintFormatItemTrlRepository]
  override lazy val printGraphRepository = wire[PrintGraphRepository]
  override lazy val printLabelRepository = wire[PrintLabelRepository]
  override lazy val printLabelLineRepository = wire[PrintLabelLineRepository]
  override lazy val printLabelLineTrlRepository = wire[PrintLabelLineTrlRepository]
  override lazy val printPaperRepository = wire[PrintPaperRepository]
  override lazy val printTableFormatRepository = wire[PrintTableFormatRepository]
  override lazy val privateAccessRepository = wire[PrivateAccessRepository]
  override lazy val processRepository = wire[ProcessRepository]
  override lazy val processAccessRepository = wire[ProcessAccessRepository]
  override lazy val processParameterRepository = wire[ProcessParameterRepository]
  override lazy val processParameterTrlRepository = wire[ProcessParameterTrlRepository]
  override lazy val processTrlRepository = wire[ProcessTrlRepository]

  override lazy val recentItemRepository = wire[RecentItemRepository]
  override lazy val recordAccessRepository = wire[RecordAccessRepository]
  override lazy val referenceRepository = wire[ReferenceRepository]
  override lazy val referenceEntityRepository = wire[ReferenceEntityRepository]
  override lazy val referenceListRepository = wire[ReferenceListRepository]
  override lazy val referenceListTrlRepository = wire[ReferenceListTrlRepository]
  override lazy val referenceTrlRepository = wire[ReferenceTrlRepository]
  override lazy val registrationRepository = wire[RegistrationRepository]
  override lazy val relationTypeRepository = wire[RelationTypeRepository]
  override lazy val replicationRepository = wire[ReplicationRepository]
  override lazy val replicationDocumentRepository = wire[ReplicationDocumentRepository]
  override lazy val replicationLogRepository = wire[ReplicationLogRepository]
  override lazy val replicationOrganizationAccessRepository = wire[ReplicationOrganizationAccessRepository]
  override lazy val replicationRoleAccessRepository = wire[ReplicationRoleAccessRepository]
  override lazy val replicationRunRepository = wire[ReplicationRunRepository]
  override lazy val replicationStrategyRepository = wire[ReplicationStrategyRepository]
  override lazy val replicationTableRepository = wire[ReplicationTableRepository]
  override lazy val reportViewRepository = wire[ReportViewRepository]
  override lazy val reportViewAttributeRepository = wire[ReportViewAttributeRepository]
  override lazy val reportViewTrlRepository = wire[ReportViewTrlRepository]
  override lazy val roleRepository = wire[RoleRepository]
  override lazy val roleIncludedRepository = wire[RoleIncludedRepository]
  override lazy val roleOrganizationAccessRepository = wire[RoleOrganizationAccessRepository]
  override lazy val ruleRepository = wire[RuleRepository]

  override lazy val schedulerRepository = wire[SchedulerRepository]
  override lazy val schedulerLogRepository = wire[SchedulerLogRepository]
  override lazy val schedulerParameterRepository = wire[SchedulerParameterRepository]
  override lazy val schedulerRecipientRepository = wire[SchedulerRecipientRepository]
  override lazy val searchDefinitionRepository = wire[SearchDefinitionRepository]
  override lazy val sequenceRepository = wire[SequenceRepository]
  override lazy val sequenceAuditRepository = wire[SequenceAuditRepository]
  override lazy val sequenceNoRepository = wire[SequenceNoRepository]
  override lazy val sessionRepository = wire[SessionRepository]
  override lazy val sysConfigRepository = wire[SysConfigRepository]
  override lazy val systemRepository = wire[SystemRepository]

  override lazy val tabRepository = wire[TabRepository]
  override lazy val tabTrlRepository = wire[TabTrlRepository]
  override lazy val taskRepository = wire[TaskRepository]
  override lazy val taskAccessRepository = wire[TaskAccessRepository]
  override lazy val taskInstanceRepository = wire[TaskInstanceRepository]
  override lazy val taskTrlRepository = wire[TaskTrlRepository]
  override lazy val tenantRepository = wire[TenantRepository]
  override lazy val tenantInfoRepository = wire[TenantInfoRepository]
  override lazy val tenantShareRepository = wire[TenantShareRepository]
  override lazy val treeRepository = wire[TreeRepository]
  override lazy val treeBarRepository = wire[TreeBarRepository]
  override lazy val treeFavoriteRepository = wire[TreeFavoriteRepository]
  override lazy val treeFavoriteNodeRepository = wire[TreeFavoriteNodeRepository]
  override lazy val treeNodeRepository = wire[TreeNodeRepository]
  override lazy val treeNodeBPRepository = wire[TreeNodeBPRepository]
  override lazy val treeNodeCMCRepository = wire[TreeNodeCMCRepository]
  override lazy val treeNodeCMMRepository = wire[TreeNodeCMMRepository]
  override lazy val treeNodeCMSRepository = wire[TreeNodeCMSRepository]
  override lazy val treeNodeCMTRepository = wire[TreeNodeCMTRepository]
  override lazy val treeNodeMMRepository = wire[TreeNodeMMRepository]
  override lazy val treeNodePRRepository = wire[TreeNodePRRepository]
  override lazy val treeNodeU1Repository = wire[TreeNodeU1Repository]
  override lazy val treeNodeU2Repository = wire[TreeNodeU2Repository]
  override lazy val treeNodeU3Repository = wire[TreeNodeU3Repository]
  override lazy val treeNodeU4Repository = wire[TreeNodeU4Repository]

  override lazy val userRepository = wire[UserRepository]
  override lazy val userBusinessPartnerAccessRepository = wire[UserBusinessPartnerAccessRepository]
  override lazy val userDefinedFieldRepository = wire[UserDefinedFieldRepository]
  override lazy val userDefinedTabRepository = wire[UserDefinedTabRepository]
  override lazy val userDefinedWindowRepository = wire[UserDefinedWindowRepository]
  override lazy val userMailRepository = wire[UserMailRepository]
  override lazy val userOrganizationAccessRepository = wire[UserOrganizationAccessRepository]
  override lazy val userQueryRepository = wire[UserQueryRepository]
  override lazy val userRolesRepository = wire[UserRolesRepository]
  override lazy val userSubstituteRepository = wire[UserSubstituteRepository]

  override lazy val viewRepository = wire[ViewRepository]
  override lazy val viewAttributeRepository = wire[ViewAttributeRepository]
  override lazy val viewAttributeTrlRepository = wire[ViewAttributeTrlRepository]
  override lazy val viewDefinitionRepository = wire[ViewDefinitionRepository]
  override lazy val viewTrlRepository = wire[ViewTrlRepository]

  override lazy val windowRepository = wire[WindowRepository]
  override lazy val windowAccessRepository = wire[WindowAccessRepository]
  override lazy val windowTrlRepository = wire[WindowTrlRepository]
  override lazy val workbenchRepository = wire[WorkbenchRepository]
  override lazy val workbenchTrlRepository = wire[WorkbenchTrlRepository]
  override lazy val workbenchWindowRepository = wire[WorkbenchWindowRepository]
  override lazy val workflowRepository = wire[WorkflowRepository]
  override lazy val workflowAccessRepository = wire[WorkflowAccessRepository]
  override lazy val workflowActivityRepository = wire[WorkflowActivityRepository]
  override lazy val workflowActivityResultRepository = wire[WorkflowActivityResultRepository]
  override lazy val workflowBlockRepository = wire[WorkflowBlockRepository]
  override lazy val workflowEventAuditRepository = wire[WorkflowEventAuditRepository]
  override lazy val workflowNextConditionRepository = wire[WorkflowNextConditionRepository]
  override lazy val workflowNodeRepository = wire[WorkflowNodeRepository]
  override lazy val workflowNodeNextRepository = wire[WorkflowNodeNextRepository]
  override lazy val workflowNodeParaRepository = wire[WorkflowNodeParaRepository]
  override lazy val workflowNodeTrlRepository = wire[WorkflowNodeTrlRepository]
  override lazy val workflowProcessRepository = wire[WorkflowProcessRepository]
  override lazy val workflowProcessDataRepository = wire[WorkflowProcessDataRepository]
  override lazy val workflowProcessorRepository = wire[WorkflowProcessorRepository]
  override lazy val workflowProcessorLogRepository = wire[WorkflowProcessorLogRepository]
  override lazy val workflowResponsibleRepository = wire[WorkflowResponsibleRepository]
  override lazy val workflowTrlRepository = wire[WorkflowTrlRepository]

  override lazy val zoomConditionRepository = wire[ZoomConditionRepository]

}

/**
  * Entity Application Loader
  */
class DictionaryApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext) = new DictionaryApplication(context) {
    override def serviceLocator = NoServiceLocator
  }

  override def loadDevMode(context: LagomApplicationContext) =
    new DictionaryApplication(context) with LagomDevModeComponents
}
