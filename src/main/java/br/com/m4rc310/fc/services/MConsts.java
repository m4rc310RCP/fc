package br.com.m4rc310.fc.services;


import br.com.m4rc310.gql.annotations.MConstants;

@MConstants
public interface MConsts {
//--------------------------------------------------
// @GraphQLQuery(name=DATE$close, description=DESC$date_close)
	public static final String DATE$close                            = "${date.close}";
//--------------------------------------------------
// @GraphQLQuery(name=DATE$open, description=DESC$date_open)
	public static final String DATE$open                             = "${date.open}";
	public static final String DESC$date_close                       = "${desc.date.close}";
	public static final String DESC$date_open                        = "${desc.date.open}";
	public static final String DESC$list_transactions                = "${desc.list.transactions}";
	public static final String DESC$mutation_close_transaction_cycle = "${desc.mutation.close.transaction.cycle}";
	public static final String DESC$mutation_open_transaction_cycle  = "${desc.mutation.open.transaction.cycle}";
	public static final String DESC$mutation_register_credit         = "${desc.mutation.register.credit}";
	public static final String DESC$mutation_register_debit          = "${desc.mutation.register.debit}";
	public static final String DESC$mutation_register_transaction    = "${desc.mutation.register.transaction}";
	public static final String DESC$number_sequence                  = "${desc.number.sequence}";
	public static final String DESC$number_transaction               = "${desc.number.transaction}";
	public static final String DESC$query_test                       = "${desc.query.test}";
	public static final String DESC$query_transaction_cycle          = "${desc.query.transaction.cycle}";
	public static final String DESC$query_transactions               = "${desc.query.transactions}";
	public static final String DESC$type_transaction                 = "${desc.type.transaction}";
	public static final String DESC$type_transaction_cycle           = "${desc.type.transaction.cycle}";
	public static final String DESC$value_balance                    = "${desc.value.balance}";
	public static final String DESC$value_transaction                = "${desc.value.transaction}";
//--------------------------------------------------
// @GraphQLQuery(name=LIST$transactions, description=DESC$list_transactions)
	public static final String LIST$transactions                     = "${list.transactions}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$close_transaction_cycle, description=DESC$mutation_close_transaction_cycle)
	public static final String MUTATION$close_transaction_cycle      = "${mutation.close.transaction.cycle}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$open_transaction_cycle, description=DESC$mutation_open_transaction_cycle)
	public static final String MUTATION$open_transaction_cycle       = "${mutation.open.transaction.cycle}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$register_credit, description=DESC$mutation_register_credit)
	public static final String MUTATION$register_credit              = "${mutation.register.credit}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$register_debit, description=DESC$mutation_register_debit)
	public static final String MUTATION$register_debit               = "${mutation.register.debit}";
//--------------------------------------------------
// @GraphQLMutation(name=MUTATION$register_transaction, description=DESC$mutation_register_transaction)
	public static final String MUTATION$register_transaction         = "${mutation.register.transaction}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$sequence, description=DESC$number_sequence)
	public static final String NUMBER$sequence                       = "${number.sequence}";
//--------------------------------------------------
// @GraphQLQuery(name=NUMBER$transaction, description=DESC$number_transaction)
	public static final String NUMBER$transaction                    = "${number.transaction}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$test, description=DESC$query_test)
	public static final String QUERY$test                            = "${query.test}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$transaction_cycle, description=DESC$query_transaction_cycle)
	public static final String QUERY$transaction_cycle               = "${query.transaction.cycle}";
//--------------------------------------------------
// @GraphQLQuery(name=QUERY$transactions, description=DESC$query_transactions)
	public static final String QUERY$transactions                    = "${query.transactions}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$transaction, description=DESC$type_transaction)
	public static final String TYPE$transaction                      = "${type.transaction}";
//--------------------------------------------------
// @GraphQLType(name=TYPE$transaction_cycle, description=DESC$type_transaction_cycle)
	public static final String TYPE$transaction_cycle                = "${type.transaction.cycle}";
//--------------------------------------------------
// @GraphQLQuery(name=VALUE$balance, description=DESC$value_balance)
	public static final String VALUE$balance                         = "${value.balance}";
//--------------------------------------------------
// @GraphQLQuery(name=VALUE$transaction, description=DESC$value_transaction)
	public static final String VALUE$transaction                     = "${value.transaction}";
}

