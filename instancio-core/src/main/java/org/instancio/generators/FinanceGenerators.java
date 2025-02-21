/*
 * Copyright 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.instancio.generators;

import org.instancio.generator.GeneratorContext;
import org.instancio.generator.specs.CreditCardGeneratorSpec;
import org.instancio.internal.generator.domain.finance.CreditCardNumberGenerator;

/**
 * Contains built-in finance-related generators.
 *
 * @since 2.11.0
 */
public class FinanceGenerators {

    private final GeneratorContext context;

    public FinanceGenerators(final GeneratorContext context) {
        this.context = context;
    }

    /**
     * Generates credit card numbers.
     *
     * <p>By default, either a Visa or MasterCard will be generated.
     *
     * @return API builder reference
     * @since 2.11.0
     */
    public CreditCardGeneratorSpec creditCard() {
        return new CreditCardNumberGenerator(context);
    }
}
