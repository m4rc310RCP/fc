package br.com.m4rc310.fc.services;


import br.com.m4rc310.gql.annotations.MConstants;

@MConstants
public interface MConsts {
//--------------------------------------------------
// @GraphQLQuery(name=ARGUMENT$company, description=DESC$argument_company)
	public static final String ARGUMENT$company                         = "${argument.company}";
//--------------------------------------------------
// @GraphQLQuery(name=ARGUMENT$consumption_account, description=DESC$argument_consumption_account)
	public static final String ARGUMENT$consumption_account             = "${argument.consumption.account}";
//--------------------------------------------------
// @GraphQLQuery(name=CODE$audit, description=DESC$code_audit)
	public static final String CODE$audit                               = "${code.audit}";
//--------------------------------------------------
// @GraphQLQuery(name=CODE$company, description=DESC$code_company)
	public static final String CODE$company                             = "${code.company}";
//--------------------------------------------------
// @GraphQLQuery(name=CODE$registration, description=DESC$code_registration)
	public static final String CODE$registration                        = "${code.registration}";
//--------------------------------------------------
// @GraphQLQuery(name=CODE$user, description=DESC$code_user)
	public static final String CODE$user                                = "${code.user}";
//--------------------------------------------------
// @GraphQLQuery(name=DATE$audit, description=DESC$date_audit)
	public static final String DATE$audit                               = "${date.audit}";
//--------------------------------------------------
// @GraphQLQuery(name=DATE$last_update, description=DESC$date_last_update)
	public static final String DATE$last_update                         = "${date.last.update}";
	public static final String DESC$argument_company                    = "${desc.argument.company}";
	public static final String DESC$argument_consumption_account        = "${desc.argument.consumption.account}";
	public static final String DESC$code_audit                          = "${desc.code.audit}";
	public static final String DESC$code_company                        = "${desc.code.company}";
	public static final String DESC$code_registration                   = "${desc.code.registration}";
	public static final String DESC$code_user                           = "${desc.code.user}";
	public static final String DESC$date_audit                          = "${desc.date.audit}";
	public static final String DESC$date_last_update                    = "${desc.date.last.update}";
	public static final String DESC$discriminator_account               = "${desc.discriminator.account}";
	public static final String DESC$discriminator_account_credit        = "${desc.discriminator.account.credit}";
	public static final String DESC$discriminator_account_debit         = "${desc.discriminator.account.debit}";
	public static final String DESC$discriminator_password              = "${desc.discriminator.password}";
	public static final String DESC$discriminator_registry              = "${desc.discriminator.registry}";
	public static final String DESC$indicator_cancel                    = "${desc.indicator.cancel}";
	public static final String DESC$kind_account                        = "${desc.kind.account}";
	public static final String DESC$list_roles                          = "${desc.list.roles}";
	public static final String DESC$mutation_add_movto                  = "${desc.mutation.add.movto}";
	public static final String DESC$mutation_cancel_company             = "${desc.mutation.cancel.company}";
	public static final String DESC$mutation_cancel_consumption_account = "${desc.mutation.cancel.consumption.account}";
	public static final String DESC$mutation_company                    = "${desc.mutation.company}";
	public static final String DESC$mutation_consumption_account        = "${desc.mutation.consumption.account}";
	public static final String DESC$name_company                        = "${desc.name.company}";
	public static final String DESC$name_username                       = "${desc.name.username}";
	public static final String DESC$number_account                      = "${desc.number.account}";
	public static final String DESC$number_cc                           = "${desc.number.cc}";
	public static final String DESC$number_movto                        = "${desc.number.movto}";
	public static final String DESC$number_sequence                     = "${desc.number.sequence}";
	public static final String DESC$number_vd                           = "${desc.number.vd}";
	public static final String DESC$query_all_companies                 = "${desc.query.all.companies}";
	public static final String DESC$query_company                       = "${desc.query.company}";
	public static final String DESC$query_consumption_account           = "${desc.query.consumption.account}";
	public static final String DESC$query_consumption_accounts          = "${desc.query.consumption.accounts}";
	public static final String DESC$query_test                          = "${desc.query.test}";
	public static final String DESC$type_audit                          = "${desc.type.audit}";
	public static final String DESC$type_company                        = "${desc.type.company}";
	public static final String DESC$type_consumption_account            = "${desc.type.consumption.account}";
	public static final String DESC$type_movto                          = "${desc.type.movto}";
	public static final String DESC$type_registration                   = "${desc.type.registration}";
	public static final String DESC$type_user                           = "${desc.type.user}";
	public static final String DESC$value_movto                         = "${desc.value.movto}";
//--------------------------------------------------
// @GraphQLQuery(name=DISCRIMINATOR$account, description=DESC$discriminator_account)
	public static final String DISCRIMINATOR$account                    = "${discriminator.account}";
//--------------------------------------------------
// @GraphQLQuery(name=DISCRIMINATOR$account_credit, description=DESC$discriminator_account_credit)
	public static final String DISCRIMINATOR$account_credit             = "${discriminator.account.credit}";
//--------------------------------------------------
// @GraphQLQuery(name=DISCRIMINATOR$account_debit, description=DESC$discriminator_account_debit)
	public static final String DISCRIMINATOR$account_debit              = "${discriminator.account.debit}";
//--------------------------------------------------
// @GraphQLQuery(name=DISCRIMINATOR$password, description=DESC$discriminator_password)
	public static final String DISCRIMINATOR$password                   = "${discriminator.password}";
//--------------------------------------------------
// @GraphQLQuery(name=DISCRIMINATOR$person, description=DESC$discriminator_person)
	public static final String DISCRIMINATOR$person                     = "${discriminator.person}";
//--------------------------------------------------
// @GraphQLQuery(name=DISCRIMINATOR$registry, description=DESC$discriminator_registry)
	public static final String DISCRIMINATOR$registry                   = "${discriminator.registry}";
//--------------------------------------------------
// @GraphQLQuery(name=ERROR$user_not_found, description=DESC$error_user_not_found)
	public static final String ERROR$user_not_found                     = "${error.user.not.found}";
//--------------------------------------------------
// @GraphQLQuery(name=INDICATOR$cancel, description=DESC$indicator_cancel)
	public static final String INDICATOR$cancel                         = "${indicator.cancel}";
//--------------------------------------------------
// @GraphQLQuery(name=INDICATOR$default, description=DESC$indicator_default)
	public static final String INDICATOR$default                        = "${indicator.default}";
//--------------------------------------------------
// @GraphQLQuery(name=KIND$account, description=DESC$kind_account)
	public static final String KIND$account                             = "${kind.account}";
//--------------------------------------------------
// @GraphQLQuery(name=LIST$roles, description=DESC$list_roles)
	public static final String LIST$roles                               = "${list.roles}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$add_movto, description=DESC$mutation_add_movto)
	public static final String MUTATION$add_movto                       = "${mutation.add.movto}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$cancel_company, description=DESC$mutation_cancel_company)
	public static final String MUTATION$cancel_company                  = "${mutation.cancel.company}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$cancel_consumption_account, description=DESC$mutation_cancel_consumption_account)
	public static final String MUTATION$cancel_consumption_account      = "${mutation.cancel.consumption.account}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$company, description=DESC$mutation_company)
	public static final String MUTATION$company                         = "${mutation.company}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$consumption_account, description=DESC$mutation_consumption_account)
	public static final String MUTATION$consumption_account             = "${mutation.consumption.account}";
//--------------------------------------------------
// @GraphQLQuery(name=NAME$company, description=DESC$name_company)
	public static final String NAME$company                             = "${name.company}";
//--------------------------------------------------
// @GraphQLQuery(name=NAME$username, description=DESC$name_username)
	public static final String NAME$username                            = "${name.username}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$account, description=DESC$number_account)
	public static final String NUMBER$account                           = "${number.account}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$cc, description=DESC$number_cc)
	public static final String NUMBER$cc                                = "${number.cc}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$movto, description=DESC$number_movto)
	public static final String NUMBER$movto                             = "${number.movto}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$sequence, description=DESC$number_sequence)
	public static final String NUMBER$sequence                          = "${number.sequence}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$vd, description=DESC$number_vd)
	public static final String NUMBER$vd                                = "${number.vd}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$all_companies, description=DESC$query_all_companies)
	public static final String QUERY$all_companies                      = "${query.all.companies}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$company, description=DESC$query_company)
	public static final String QUERY$company                            = "${query.company}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$consumption_account, description=DESC$query_consumption_account)
	public static final String QUERY$consumption_account                = "${query.consumption.account}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$consumption_accounts, description=DESC$query_consumption_accounts)
	public static final String QUERY$consumption_accounts               = "${query.consumption.accounts}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$test, description=DESC$query_test)
	public static final String QUERY$test                               = "${query.test}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$audit, description=DESC$type_audit)
	public static final String TYPE$audit                               = "${type.audit}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$company, description=DESC$type_company)
	public static final String TYPE$company                             = "${type.company}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$consumption_account, description=DESC$type_consumption_account)
	public static final String TYPE$consumption_account                 = "${type.consumption.account}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$movto, description=DESC$type_movto)
	public static final String TYPE$movto                               = "${type.movto}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$person, description=DESC$type_person)
	public static final String TYPE$person                              = "${type.person}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$person_juridical, description=DESC$type_person_juridical)
	public static final String TYPE$person_juridical                    = "${type.person.juridical}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$person_physical, description=DESC$type_person_physical)
	public static final String TYPE$person_physical                     = "${type.person.physical}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$registration, description=DESC$type_registration)
	public static final String TYPE$registration                        = "${type.registration}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$user, description=DESC$type_user)
	public static final String TYPE$user                                = "${type.user}";
//--------------------------------------------------
// @GraphQLQuery(name=VALUE$movto, description=DESC$value_movto)
	public static final String VALUE$movto                              = "${value.movto}";
}

