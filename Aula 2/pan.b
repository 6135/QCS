	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* PROC Q */
;
		;
		
	case 4: /* STATE 4 */
		;
		((P0 *)this)->_1_i = trpt->bup.ovals[1];
		((P0 *)this)->_1_result = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		
	case 5: /* STATE 11 */
		goto R999;

	case 6: /* STATE 13 */
		;
		p_restor(II);
		;
		;
		goto R999;
	}

