#define rand	pan_rand
#if defined(HAS_CODE) && defined(VERBOSE)
	cpu_printf("Pr: %d Tr: %d\n", II, t->forw);
#endif
	switch (t->forw) {
	default: Uerror("bad forward move");
	case 0:	/* if without executable clauses */
		continue;
	case 1: /* generic 'goto' or 'skip' */
		IfNotBlocked
		_m = 3; goto P999;
	case 2: /* generic 'else' */
		IfNotBlocked
		if (trpt->o_pm&1) continue;
		_m = 3; goto P999;

		 /* PROC Q */
	case 3: /* STATE 1 - sumEx1:5 - [((i<=5))] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][1] = 1;
		if (!((((P0 *)this)->_1_i<=5)))
			continue;
		_m = 3; goto P999; /* 0 */
	case 4: /* STATE 2 - sumEx1:6 - [result = (result+i)] (0:8:2 - 1) */
		IfNotBlocked
		reached[0][2] = 1;
		(trpt+1)->bup.ovals = grab_ints(2);
		(trpt+1)->bup.ovals[0] = ((P0 *)this)->_1_result;
		((P0 *)this)->_1_result = (((P0 *)this)->_1_result+((P0 *)this)->_1_i);
#ifdef VAR_RANGES
		logval("Q:result", ((P0 *)this)->_1_result);
#endif
		;
		/* merge: printf('Sum: %d\\n',result)(8, 3, 8) */
		reached[0][3] = 1;
		Printf("Sum: %d\n", ((P0 *)this)->_1_result);
		/* merge: i = (i+1)(8, 4, 8) */
		reached[0][4] = 1;
		(trpt+1)->bup.ovals[1] = ((P0 *)this)->_1_i;
		((P0 *)this)->_1_i = (((P0 *)this)->_1_i+1);
#ifdef VAR_RANGES
		logval("Q:i", ((P0 *)this)->_1_i);
#endif
		;
		/* merge: .(goto)(0, 9, 8) */
		reached[0][9] = 1;
		;
		_m = 3; goto P999; /* 3 */
	case 5: /* STATE 11 - sumEx1:12 - [printf('Sum: %d\\n',result)] (0:13:0 - 3) */
		IfNotBlocked
		reached[0][11] = 1;
		Printf("Sum: %d\n", ((P0 *)this)->_1_result);
		/* merge: assert((result==supposedRes))(13, 12, 13) */
		reached[0][12] = 1;
		spin_assert((((P0 *)this)->_1_result==((P0 *)this)->_1_supposedRes), "(result==supposedRes)", II, tt, t);
		_m = 3; goto P999; /* 1 */
	case 6: /* STATE 13 - sumEx1:17 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][13] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */
	case  _T5:	/* np_ */
		if (!((!(trpt->o_pm&4) && !(trpt->tau&128))))
			continue;
		/* else fall through */
	case  _T2:	/* true */
		_m = 3; goto P999;
#undef rand
	}

