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

		 /* PROC Troca */
	case 3: /* STATE 1 - Troca.pml:5 - [((a<10))] (4:0:1 - 1) */
		IfNotBlocked
		reached[0][1] = 1;
		if (!((((P0 *)this)->_1_a<10)))
			continue;
		/* merge: a = (a+1)(0, 2, 4) */
		reached[0][2] = 1;
		(trpt+1)->bup.oval = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_a+1);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: .(goto)(0, 5, 4) */
		reached[0][5] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 4: /* STATE 3 - Troca.pml:6 - [goto :b0] (0:12:1 - 1) */
		IfNotBlocked
		reached[0][3] = 1;
		;
		/* merge: aa = a(12, 7, 12) */
		reached[0][7] = 1;
		(trpt+1)->bup.oval = ((P0 *)this)->_1_aa;
		((P0 *)this)->_1_aa = ((P0 *)this)->_1_a;
#ifdef VAR_RANGES
		logval("Troca:aa", ((P0 *)this)->_1_aa);
#endif
		;
		/* merge: assert(((a<=10)&&(a>=1)))(12, 8, 12) */
		reached[0][8] = 1;
		spin_assert(((((P0 *)this)->_1_a<=10)&&(((P0 *)this)->_1_a>=1)), "((a<=10)&&(a>=1))", II, tt, t);
		/* merge: .(goto)(0, 13, 12) */
		reached[0][13] = 1;
		;
		_m = 3; goto P999; /* 3 */
	case 5: /* STATE 7 - Troca.pml:8 - [aa = a] (0:12:1 - 2) */
		IfNotBlocked
		reached[0][7] = 1;
		(trpt+1)->bup.oval = ((P0 *)this)->_1_aa;
		((P0 *)this)->_1_aa = ((P0 *)this)->_1_a;
#ifdef VAR_RANGES
		logval("Troca:aa", ((P0 *)this)->_1_aa);
#endif
		;
		/* merge: assert(((a<=10)&&(a>=1)))(12, 8, 12) */
		reached[0][8] = 1;
		spin_assert(((((P0 *)this)->_1_a<=10)&&(((P0 *)this)->_1_a>=1)), "((a<=10)&&(a>=1))", II, tt, t);
		/* merge: .(goto)(0, 13, 12) */
		reached[0][13] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 6: /* STATE 9 - Troca.pml:12 - [((b<10))] (12:0:1 - 1) */
		IfNotBlocked
		reached[0][9] = 1;
		if (!((((P0 *)this)->_1_b<10)))
			continue;
		/* merge: b = (b+1)(0, 10, 12) */
		reached[0][10] = 1;
		(trpt+1)->bup.oval = ((P0 *)this)->_1_b;
		((P0 *)this)->_1_b = (((P0 *)this)->_1_b+1);
#ifdef VAR_RANGES
		logval("Troca:b", ((P0 *)this)->_1_b);
#endif
		;
		/* merge: .(goto)(0, 13, 12) */
		reached[0][13] = 1;
		;
		_m = 3; goto P999; /* 2 */
	case 7: /* STATE 11 - Troca.pml:13 - [goto :b1] (0:21:1 - 1) */
		IfNotBlocked
		reached[0][11] = 1;
		;
		/* merge: bb = b(21, 15, 21) */
		reached[0][15] = 1;
		(trpt+1)->bup.oval = ((P0 *)this)->_1_bb;
		((P0 *)this)->_1_bb = ((P0 *)this)->_1_b;
#ifdef VAR_RANGES
		logval("Troca:bb", ((P0 *)this)->_1_bb);
#endif
		;
		/* merge: assert(((b<=10)&&(b>=1)))(21, 16, 21) */
		reached[0][16] = 1;
		spin_assert(((((P0 *)this)->_1_b<=10)&&(((P0 *)this)->_1_b>=1)), "((b<=10)&&(b>=1))", II, tt, t);
		_m = 3; goto P999; /* 2 */
	case 8: /* STATE 15 - Troca.pml:15 - [bb = b] (0:21:1 - 2) */
		IfNotBlocked
		reached[0][15] = 1;
		(trpt+1)->bup.oval = ((P0 *)this)->_1_bb;
		((P0 *)this)->_1_bb = ((P0 *)this)->_1_b;
#ifdef VAR_RANGES
		logval("Troca:bb", ((P0 *)this)->_1_bb);
#endif
		;
		/* merge: assert(((b<=10)&&(b>=1)))(21, 16, 21) */
		reached[0][16] = 1;
		spin_assert(((((P0 *)this)->_1_b<=10)&&(((P0 *)this)->_1_b>=1)), "((b<=10)&&(b>=1))", II, tt, t);
		_m = 3; goto P999; /* 1 */
	case 9: /* STATE 17 - Troca.pml:19 - [(((a==3)&&(b==7)))] (27:0:3 - 1) */
		IfNotBlocked
		reached[0][17] = 1;
		if (!(((((P0 *)this)->_1_a==3)&&(((P0 *)this)->_1_b==7))))
			continue;
		/* merge: assert(((a!=3)&&(b!=7)))(27, 18, 27) */
		reached[0][18] = 1;
		spin_assert(((((P0 *)this)->_1_a!=3)&&(((P0 *)this)->_1_b!=7)), "((a!=3)&&(b!=7))", II, tt, t);
		/* merge: .(goto)(27, 22, 27) */
		reached[0][22] = 1;
		;
		/* merge: a = (a-b)(27, 23, 27) */
		reached[0][23] = 1;
		(trpt+1)->bup.ovals = grab_ints(3);
		(trpt+1)->bup.ovals[0] = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_a-((P0 *)this)->_1_b);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: b = (a+b)(27, 24, 27) */
		reached[0][24] = 1;
		(trpt+1)->bup.ovals[1] = ((P0 *)this)->_1_b;
		((P0 *)this)->_1_b = (((P0 *)this)->_1_a+((P0 *)this)->_1_b);
#ifdef VAR_RANGES
		logval("Troca:b", ((P0 *)this)->_1_b);
#endif
		;
		/* merge: a = (b-a)(27, 25, 27) */
		reached[0][25] = 1;
		(trpt+1)->bup.ovals[2] = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_b-((P0 *)this)->_1_a);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: assert(((a==bb)&&(b==aa)))(27, 26, 27) */
		reached[0][26] = 1;
		spin_assert(((((P0 *)this)->_1_a==((P0 *)this)->_1_bb)&&(((P0 *)this)->_1_b==((P0 *)this)->_1_aa)), "((a==bb)&&(b==aa))", II, tt, t);
		_m = 3; goto P999; /* 6 */
	case 10: /* STATE 20 - Troca.pml:20 - [(1)] (27:0:3 - 1) */
		IfNotBlocked
		reached[0][20] = 1;
		if (!(1))
			continue;
		/* merge: .(goto)(27, 22, 27) */
		reached[0][22] = 1;
		;
		/* merge: a = (a-b)(27, 23, 27) */
		reached[0][23] = 1;
		(trpt+1)->bup.ovals = grab_ints(3);
		(trpt+1)->bup.ovals[0] = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_a-((P0 *)this)->_1_b);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: b = (a+b)(27, 24, 27) */
		reached[0][24] = 1;
		(trpt+1)->bup.ovals[1] = ((P0 *)this)->_1_b;
		((P0 *)this)->_1_b = (((P0 *)this)->_1_a+((P0 *)this)->_1_b);
#ifdef VAR_RANGES
		logval("Troca:b", ((P0 *)this)->_1_b);
#endif
		;
		/* merge: a = (b-a)(27, 25, 27) */
		reached[0][25] = 1;
		(trpt+1)->bup.ovals[2] = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_b-((P0 *)this)->_1_a);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: assert(((a==bb)&&(b==aa)))(27, 26, 27) */
		reached[0][26] = 1;
		spin_assert(((((P0 *)this)->_1_a==((P0 *)this)->_1_bb)&&(((P0 *)this)->_1_b==((P0 *)this)->_1_aa)), "((a==bb)&&(b==aa))", II, tt, t);
		_m = 3; goto P999; /* 5 */
	case 11: /* STATE 23 - Troca.pml:24 - [a = (a-b)] (0:27:3 - 3) */
		IfNotBlocked
		reached[0][23] = 1;
		(trpt+1)->bup.ovals = grab_ints(3);
		(trpt+1)->bup.ovals[0] = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_a-((P0 *)this)->_1_b);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: b = (a+b)(27, 24, 27) */
		reached[0][24] = 1;
		(trpt+1)->bup.ovals[1] = ((P0 *)this)->_1_b;
		((P0 *)this)->_1_b = (((P0 *)this)->_1_a+((P0 *)this)->_1_b);
#ifdef VAR_RANGES
		logval("Troca:b", ((P0 *)this)->_1_b);
#endif
		;
		/* merge: a = (b-a)(27, 25, 27) */
		reached[0][25] = 1;
		(trpt+1)->bup.ovals[2] = ((P0 *)this)->_1_a;
		((P0 *)this)->_1_a = (((P0 *)this)->_1_b-((P0 *)this)->_1_a);
#ifdef VAR_RANGES
		logval("Troca:a", ((P0 *)this)->_1_a);
#endif
		;
		/* merge: assert(((a==bb)&&(b==aa)))(27, 26, 27) */
		reached[0][26] = 1;
		spin_assert(((((P0 *)this)->_1_a==((P0 *)this)->_1_bb)&&(((P0 *)this)->_1_b==((P0 *)this)->_1_aa)), "((a==bb)&&(b==aa))", II, tt, t);
		_m = 3; goto P999; /* 3 */
	case 12: /* STATE 27 - Troca.pml:32 - [-end-] (0:0:0 - 1) */
		IfNotBlocked
		reached[0][27] = 1;
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

