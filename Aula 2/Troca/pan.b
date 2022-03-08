	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* PROC Troca */

	case 3: /* STATE 2 */
		;
		((P0 *)this)->_1_a = trpt->bup.oval;
		;
		goto R999;

	case 4: /* STATE 7 */
		;
		((P0 *)this)->_1_aa = trpt->bup.oval;
		;
		goto R999;

	case 5: /* STATE 7 */
		;
		((P0 *)this)->_1_aa = trpt->bup.oval;
		;
		goto R999;

	case 6: /* STATE 10 */
		;
		((P0 *)this)->_1_b = trpt->bup.oval;
		;
		goto R999;

	case 7: /* STATE 15 */
		;
		((P0 *)this)->_1_bb = trpt->bup.oval;
		;
		goto R999;

	case 8: /* STATE 15 */
		;
		((P0 *)this)->_1_bb = trpt->bup.oval;
		;
		goto R999;

	case 9: /* STATE 25 */
		;
		((P0 *)this)->_1_a = trpt->bup.ovals[2];
		((P0 *)this)->_1_b = trpt->bup.ovals[1];
		((P0 *)this)->_1_a = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 3);
		goto R999;

	case 10: /* STATE 25 */
		;
		((P0 *)this)->_1_a = trpt->bup.ovals[2];
		((P0 *)this)->_1_b = trpt->bup.ovals[1];
		((P0 *)this)->_1_a = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 3);
		goto R999;

	case 11: /* STATE 25 */
		;
		((P0 *)this)->_1_a = trpt->bup.ovals[2];
		((P0 *)this)->_1_b = trpt->bup.ovals[1];
		((P0 *)this)->_1_a = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 3);
		goto R999;

	case 12: /* STATE 27 */
		;
		p_restor(II);
		;
		;
		goto R999;
	}

